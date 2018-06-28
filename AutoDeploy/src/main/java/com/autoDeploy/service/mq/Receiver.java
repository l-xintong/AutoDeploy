package com.autoDeploy.service.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.Date;

@RabbitListener(queues="message")
public class Receiver {

	Logger logger = LoggerFactory.getLogger(Receiver.class);
	@RabbitHandler
	public void process(String Str) {
		logger.info("接收消息："+Str);
		logger.info("接收消息时间："+new Date());
	}


}
