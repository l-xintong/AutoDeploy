package com.autoDeploy.controller;


import com.autoDeploy.common.result.Query;
import com.autoDeploy.entity.ManageDeploy;
import com.autoDeploy.service.ManageDeployService;
import com.autoDeploy.service.UserService;
import com.autoDeploy.util.BaseResultUtil;
import com.autoDeploy.util.EnhanceBaseResultUtil;
import com.autoDeploy.util.UpLoadUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lee
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/manageDeploy")
public class ManageDeployController extends BaseController {
	@Autowired
	private ManageDeployService manageDeployService;
	@Autowired
	private UserService userService;

	String result="";

	private static final Logger logger = LoggerFactory.getLogger(UpLoadUtil.class);

	@PostMapping("/testCod")
	public ResponseEntity<BaseResultUtil> testCod(String code){
		System.out.println(code);
		System.out.println("result"+result);

		if (code.equals(result)) {
			System.out.println("成功");
			return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("成功"));
		}

		return ResponseEntity.ok(EnhanceBaseResultUtil.FailedResult("失败"));
	}

	@GetMapping("/getMessage")
	public  ResponseEntity<BaseResultUtil> getMessage(Long id){
		String phoneNum = userService.selectPhoneNumById(id);

		result = manageDeployService.testCode(phoneNum);
		if("cuo".equals(result)){
			return ResponseEntity.ok(EnhanceBaseResultUtil.FailedResult("失败"));
		}
		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("成功"));

	}

	@PostMapping("/save")
   public  ResponseEntity<BaseResultUtil> saveDeploy(@RequestBody ManageDeploy manageDeploy){
		System.out.println(manageDeploy.toString());
		manageDeployService.insert(manageDeploy);
		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("成功"));
   }


   @GetMapping("/")
   public ResponseEntity<BaseResultUtil> queryList(@RequestParam Map<String, Object> params){

	   Query query = new Query(params);

	   Page<ManageDeploy> pageUtil = new Page<>(query.getPage(),query.getLimit());

	   Page<ManageDeploy> page = manageDeployService.selectPage(pageUtil,query);

	   return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("查询全部用户成功", page,"http://localhost:8080/manageDeploy/?page=2&limit=10"));
   }



   @GetMapping("/{id}")
	public ResponseEntity<BaseResultUtil> selectById(@PathVariable(value = "id") int id) {

		ManageDeploy m = manageDeployService.selectById(1);

		return  ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("查询成功", m));
	}
}
