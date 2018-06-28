package com.autoDeploy.controller;


import com.autoDeploy.common.result.ResultBody;
import com.autoDeploy.entity.User;
import com.autoDeploy.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lee
 * @since 2018-05-18
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@PostMapping("/update/{id}")
	@ResponseBody
	public String update(@PathVariable(value = "id") Integer id){

		User u = new User(id,"张四",0,"as1234");
		return  ResultBody.success(userService.update(u,new EntityWrapper<User>().eq("id",id)));
	}
	@GetMapping("/{id}")
	@ResponseBody
	public String selectUserById(@PathVariable(value = "id") Integer id){

		return ResultBody.success(userService.selectById(id));
	}


	@PostMapping("/in")
	@ResponseBody
	public String insertUser(){
		User u = new User();
		u.setUsername("lee");
		u.setPassword("123");
		u.setStatus(0);

		return ResultBody.success(userService.insert(u));
	}

	//@SysLog("aop日志测试")
	@GetMapping("/all")
	@ResponseBody
	public String selectUserList(@RequestParam(value = "currentpage",required = false, defaultValue ="1") Integer currentpage,
								 @RequestParam(value = "count",required = false,defaultValue = "3") Integer count,
								 @RequestParam(value = "status",required = false,defaultValue = "0") Integer status
	){

		Page<User> page = new Page<>(currentpage,count);
		return ResultBody.success(userService.selectPage(page,new EntityWrapper<User>().eq("status",status)));
	}


	@PostMapping("/{id}")
	@ResponseBody
	//@SysLog
	public String deletByName(@PathVariable(value = "id") Integer id){
		userService.deleteById(id);
		return ResultBody.success();
	}



	
}
