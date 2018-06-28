package com.autoDeploy.controller;

import com.autoDeploy.service.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

	@Autowired
	private Sender sender;

	@GetMapping("/send")
	public String send(){
		return sender.send();
	}
}
