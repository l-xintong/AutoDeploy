package com.autoDeploy.service.mq;

import lombok.Getter;

@Getter
public enum QueueEnum {

	/**
	 * 添加任务枚举
	 */
	job_add("job.add.queue","job.add")
	;
	/**
	 * 队列名称
	 */
	private String name;
	/**
	 * 队列路由键
	 */
	private String routingKey;

	QueueEnum(String name, String routingKey) {
		this.name = name;
		this.routingKey = routingKey;
	}
}
