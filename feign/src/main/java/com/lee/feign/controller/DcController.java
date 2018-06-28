package com.lee.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

	@Autowired
	private DcClient dcClient;


	@GetMapping("/cs")
	public String dc(){
		return dcClient.consumer();
	}

}
