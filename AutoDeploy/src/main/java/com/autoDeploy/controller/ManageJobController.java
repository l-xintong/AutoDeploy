package com.autoDeploy.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.autoDeploy.entity.ManageJob;
import com.autoDeploy.entity.po.PoManageJob;
import com.autoDeploy.service.ManageJobService;
import com.autoDeploy.service.mq.ExchangeEnum;
import com.autoDeploy.service.mq.QueueEnum;
import com.autoDeploy.service.mq.QueueMessageServiceSupport;
import com.autoDeploy.util.BaseResultUtil;
import com.autoDeploy.util.EnhanceBaseResultUtil;
import com.autoDeploy.util.UpLoadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/manageJobs")
public class ManageJobController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(UpLoadUtil.class);

	@Autowired
	private ManageJobService manageJobService;

	@Autowired
	private QueueMessageServiceSupport queueMessageServiceSupport;

//	@GetMapping("/pagelist")
//	@ResponseBody
//	public R selectJobList(@RequestParam(value = "currentpage",required = false, defaultValue ="1") Integer page,
//						   @RequestParam(value = "count",required = false,defaultValue = "3") Integer limit,
//						  String name,Integer type){
//		Map<String, Object> params=new HashMap<>(16);
//		params.put("name",name);
//		params.put("type",type);
//		Page<ManageJob> pageUtil = new Page<>(page,limit);
//		Page<ManageJob> result = manageJobService.selectPageList(pageUtil,params);
//		return R.ok().put("page",result);
//
//	}

	@GetMapping(value = "/")
	@ResponseBody
	public ResponseEntity<BaseResultUtil> getUserListByParams(String job_name, Integer job_type) throws Exception {

		Map<String, Object> params = new HashMap<>(16);
		params.put("job_name", job_name);
		params.put("job_type", job_type);
		List<PoManageJob> userList = manageJobService.findAll(params);
//		for(PoManageJob job:userList){
//
//			queueMessageServiceSupport.send(JSON.toJSONString(job),ExchangeEnum.job_add,QueueEnum.job_add);
//		}

		queueMessageServiceSupport.send(JSONArray.toJSONString(userList),ExchangeEnum.job_add,QueueEnum.job_add);
		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("查询全部用户成功", userList, userList.size()));
	}


//	//保存任务
//	@PostMapping(value ="/")
//	@ResponseBody
//	public ResponseEntity<BaseResultUtil> save(ManageJob manageJob){
//
//		boolean result=manageJobService.insert(manageJob);
//		//校验返回值，是否添加成功
//		if (!result) {
//			return ResponseEntity.ok(EnhanceBaseResultUtil.FailedResult("添加失败"));
//		}
//		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("添加成功"));
//
//	}

	//保存或更新任务
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<BaseResultUtil> addOrUpdate(ManageJob manageJob) {

		boolean result = manageJobService.insertOrUpdate(manageJob);
		if (!result) {
			return ResponseEntity.ok(EnhanceBaseResultUtil.FailedResult("添加或更新失败"));
		}
		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("添加或更新成功"));
	}


	//通过ID删除任务
	@DeleteMapping(value ="/{id}")
	@ResponseBody
	public ResponseEntity<BaseResultUtil> delete(@PathVariable(value = "id")Long id) {

		boolean result = manageJobService.deleteById(id);
		if (!result) {
			return ResponseEntity.ok(EnhanceBaseResultUtil.FailedResult("删除失败"));
		}
		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("删除成功"));

	}
	//通过ID查询

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<BaseResultUtil> selectByID(@PathVariable(value = "id") Long id) {

		ManageJob manageJob = manageJobService.selectById(id);
		if (manageJob == null) {
			return ResponseEntity.ok(EnhanceBaseResultUtil.FailedResult("任务不存在", manageJob));
		}

		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("查询成功", manageJob));
	}


	@PostMapping(value = "/saveFile")
	@ResponseBody
	public String saveFile(MultipartFile packgeName, String packgeUrl) {

		manageJobService.saveFile(packgeName,packgeUrl);
		return null;

	}


	@PostMapping(value = "/save")
	@ResponseBody
	public ResponseEntity<BaseResultUtil> save(ManageJob manageJob) throws Exception{

		manageJobService.insert(manageJob);
		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("成功"));
	}




}
