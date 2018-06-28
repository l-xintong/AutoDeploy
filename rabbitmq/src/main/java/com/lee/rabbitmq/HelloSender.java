package com.lee.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class HelloSender implements RabbitTemplate.ReturnCallback {

	@Autowired
	private RabbitTemplate rabbitTemplate;


	public void send() {
		String context = "你好现在是 " + new Date() +"";
		System.out.println("HelloSender发送内容 : " + context);
//        this.rabbitTemplate.setConfirmCallback(this);
		this.rabbitTemplate.setReturnCallback(this);

		this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			if (!ack) {
				System.out.println("HelloSender消息发送失败" + cause + correlationData.toString());
			} else {
				System.out.println("HelloSender 消息发送成功 ");
			}
		});
		this.rabbitTemplate.convertAndSend("hello", context);
	}

//topic

	public void send1() {
		String context = "hi, i am message all";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
	}
	public void send2() {
		String context = "hi, i am message 1";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
	}
	public void send3() {
		String context = "hi, i am messages 2";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
	}





	@Override
	public void returnedMessage(Message message, int i, String s, String s1, String s2) {
		System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s2);

	}
}
