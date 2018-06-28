package com.lee.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitTopic {
	Logger logger = LoggerFactory.getLogger(RabbitTopic.class);

	final static String message = "topic.message";
	final static String messages = "topic.messages";
	//创建队列
	@Bean
	public Queue queueMessage() {
		logger.info("initQQQQ");
		return new Queue(RabbitTopic.message);
	}
	//创建队列
	@Bean
	public Queue queueMessages() {
		return new Queue(RabbitTopic.messages);
	}
	//创建交换器
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("topicExchange");
	}
   //对列绑定并关联到ROUTINGKEY
	@Bean
	Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}
	//对列绑定并关联到ROUTINGKEY
	@Bean
	Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
  }
}
