package com.lee.mqconsumer;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RabbitListener(queues = "job.add.queue")
public class JobConsumer {

	@RabbitHandler
	public void execute(String s)
	{
		System.out.println("查询成功");

		List<PoManageJob> jobList = JSON.parseArray(s,PoManageJob.class);

		for(PoManageJob poManageJob : jobList){
			System.out.println("任务名称: "+ poManageJob.getJobName());
		}
		System.out.println(s);
		//channel.basicAck(tag,false);

		//...//自行业务逻辑处理
	}


}
