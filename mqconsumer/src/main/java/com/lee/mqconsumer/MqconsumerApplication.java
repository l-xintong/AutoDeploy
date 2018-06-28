package com.lee.mqconsumer;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class MqconsumerApplication {
	 private static org.slf4j.Logger logger = LoggerFactory.getLogger(MqconsumerApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(MqconsumerApplication.class, args);
		logger.info("【【【【【消息队列-消息消费者启动成功.】】】】】");
	}
}
