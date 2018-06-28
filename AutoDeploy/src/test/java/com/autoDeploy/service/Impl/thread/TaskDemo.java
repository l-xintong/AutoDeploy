package com.autoDeploy.service.Impl.thread;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDemo {

	private  int corePoolSize = Runtime.getRuntime().availableProcessors();
	private  ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,corePoolSize*2,1000,
			TimeUnit.MICROSECONDS,new LinkedBlockingDeque<Runnable>(1000));


	@Test
	public  void test(){
		CountDownLatch latch = new CountDownLatch(4);

	    executor.execute(new Task("任务A"));
		executor.execute(new Task("任务B"));
		executor.execute(new Task("任务C"));
		executor.execute(new Task("任务D"));
		try {
			latch.await();

		}catch (Exception e){

		}


		System.out.println("所有的统计任务执行完成:" + new Date());
		}

}
