package com.lee.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class M1Controller {

	@Autowired
	private HelloSender helloSender;

	/**
	 * 单生产者-单个消费者(消息确认模式)
	 */
	@GetMapping("/test1")
	public void hello()  {
		helloSender.send();
	}

	/**
	 * 单生产者-多个消费者(消息确认模式)
	 */

	@GetMapping("/test2")
	public void hello2()  {
		for(int i=10;i>0;i--)
		helloSender.send();
	}

	@GetMapping("/test3")
	public void topicMessage(){
		helloSender.send1();
		helloSender.send2();
		helloSender.send3();
	}



}
