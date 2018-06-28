package com.autoDeploy.controller;

import com.alibaba.fastjson.JSONObject;
import com.autoDeploy.entity.ManageJob;
import com.autoDeploy.interfaceTimer.RequestTimes;
import com.autoDeploy.service.ManageJobService;
import com.autoDeploy.util.BaseResultUtil;
import com.autoDeploy.util.EnhanceBaseResultUtil;
import com.autoDeploy.util.UpLoadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/base")
public class BaseController {

	@Autowired
	private ManageJobService manageJobService;

	private static final Logger logger = LoggerFactory.getLogger(UpLoadUtil.class);

	@RequestMapping("/")
	public String show(){

		return "bathcIndex";
	}

	@GetMapping("/toManageJob")
	public String showJob(){

		return "JobList";
	}

	@GetMapping("/toUpLoad")
	public String upLoad(){

		return "Upload";
	}

	@GetMapping("/toAdd")
	public String add(){

		return "addmanagejob";
	}

	@RequestMapping(value= "/test",method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<BaseResultUtil> test(String jobData){
		logger.info(jobData);
//		String fileName = jobData.substring(jobData.lastIndexOf('\\')+1,jobData.indexOf('.'));
//		logger.info(fileName);

		ManageJob manageJob = JSONObject.parseObject(jobData,ManageJob.class);
	    boolean result = manageJobService.insert(manageJob);
		return ResponseEntity.ok(EnhanceBaseResultUtil.SucceeResult("成功"));
	}


	@GetMapping("/toCod")
	public String cod(){

		return "getMessage";
	}

	@GetMapping("/toAddDeploy")
	public  String deploy(){
		return "addmanageDeploy";
	}






}
