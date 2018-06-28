package com.autoDeploy.service.Impl.thread;

import com.autoDeploy.entity.City;
import com.autoDeploy.service.CityService;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable{

	String taskName;
	private Lock lock =new  ReentrantLock();


	@Autowired
	private CityService cityService;

	public Task(String taskName){
		this.taskName = taskName;
	}

	@Override
	public void run()  {
		System.out.println(taskName+ " do stats begin at "+ new Date());
		//AtomicLong count  = new AtomicLong(0);

		doWork();
		System.out.println(taskName + " do stats complete at "+ new Date());

	}

	AtomicInteger i = new AtomicInteger(0);
	  private synchronized void  doWork(){
		  System.out.println( new Date()+"  " + i.incrementAndGet());



	  }
}
