package com.autoDeploy.service.Impl.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Runner implements Runnable {
	private String name;
	private CyclicBarrier cyclicBarrier;
	public Runner(CyclicBarrier cyclicBarrier,String name) {
		this.name = name;
		this.cyclicBarrier=cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000*new Random().nextInt(5));
			System.out.println(Thread.currentThread().getName() +"已经准备好");
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.err.println(Thread.currentThread().getName() +"出发！！");
	}

}
