package com.autoDeploy.service.mq;

import lombok.Getter;

@Getter
public enum ExchangeEnum {

	/**
	 * 添加任务交换配置枚举
	 */
	job_add("job.add.topic.exchange");

	private String value;

	ExchangeEnum(String value) {
		this.value = value;
	}

}
