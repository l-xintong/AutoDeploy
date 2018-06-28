package com.autoDeploy.service.mq;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRegisterQueueConfiguration {

	/**
	 * 配置路由交换对象实例
	 * @return
	 */
	@Bean
	public DirectExchange userRegisterDirectExchange()
	{
		return new DirectExchange(ExchangeEnum.job_add.getValue());
	}

	/**
	 * 配置用户注册队列对象实例
	 * 并设置持久化队列
	 * @return
	 */
	@Bean
	public Queue userRegisterQueue()
	{
		return new Queue(QueueEnum.job_add.getName(),true);
	}

	/**
	 * 将用户注册队列绑定到路由交换配置上并设置指定路由键进行转发
	 * @return
	 */
	@Bean
	public Binding userRegisterBinding()
	{
		return BindingBuilder.bind(userRegisterQueue()).to(userRegisterDirectExchange()).with(QueueEnum.job_add.getRoutingKey());
	}
	/**
	 *
	 DirectExchange 配置交换实例
	 配置DirectExchange实例对象，为交换设置一个名称，引用ExchangeEnum枚举配置的交换名称，消息提供者与消息消费者的交换名称必须一致才具备的第一步的通讯基础。

	 Queue 配置队列实例
	 配置Queue实例对象，为消息队列设置一个名称，引用QueueEnum枚举配置的队列名称，当然队列的名称同样也是提供者与消费者之间的通讯基础。

	 Binding 绑定队列实例到交换实例
	 配置Binding实例对象，消息绑定的目的就是将Queue实例绑定到Exchange上，并且通过设置的路由Key进行消息转发，配置了路由Key后，只有符合该路由配置的消息才会被
	 转发到绑定交换上的消息队列。


	 */


}
