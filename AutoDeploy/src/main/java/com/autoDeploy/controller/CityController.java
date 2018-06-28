package com.autoDeploy.controller;


import com.autoDeploy.interfaceTimer.RequestTimes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lee
 * @since 2018-05-18
 */
@RestController
@RequestMapping("/city")
public class CityController extends BaseController {

    //测试接口限制
	@RequestTimes(time = 15000)
	@GetMapping("hello.do")
	public String hello(HttpServletRequest request) {
		System.out.println(request.getAttribute("ifovertimes"));
		if (request.getAttribute("ifovertimes").equals("false")) {
			System.out.println("hello.do");
			return "hello redis_springboot_mybatis_mysql";
		}
		return "HTTP请求超出设定的限制";
	}
	
}
