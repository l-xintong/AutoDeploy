package com.lee.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver3 {

	@RabbitHandler
	public void process(String message, Channel channel, Message ms) throws Exception {
		System.out.println("Topic Receiver3 : " + message);
		channel.basicAck(ms.getMessageProperties().getDeliveryTag(),false);
	}
}
