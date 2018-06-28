package com.autoDeploy.service.Impl.thread;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SemaphoreTest {

	@Test
	public void SpTest(){

		ExecutorService exec = Executors.newCachedThreadPool();
		// 创建许可数为3和非公平的公平设置的 Semaphore。
		final Semaphore semp = new Semaphore(3);
		// 模拟10个客户端访问
		for (int index = 0; index < 10; index++) {
			Runnable run = new Runnable() {
				public void run() {
					try {
						// 从此信号量获取一个许可
						semp.acquire();
						System.out.println(Thread.currentThread().getName());
					} catch (Exception e) {
					} finally {
						// 释放信号量。如果没有这条语句，则在控制台只能打印5条记录，之后线程一直阻塞
						semp.release();
					}
				}
			};
			exec.execute(run);
		}
		exec.shutdown();

	}

	@Test
	public void sempTest(){
		ExecutorService exec = Executors.newCachedThreadPool();

		// 只能5个线程同时访问
		final Semaphore sp = new    Semaphore(3);

		// 模拟10个客户端访问
		for (int index = 0; index < 7; index++) {
			Runnable rb = new Runnable() {
				public void run() {
					try {
						sp.acquire(); // 获取许可

						System.out.println("线程" + Thread.currentThread().getName() +
								"进入,当前已有" + (3-sp.availablePermits()) + "个并发");
						//availablePermits()  返回此信号量中当前可用的许可数。

						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() + "即将离开");

						sp.release();// 访问完后，释放

						System.out.println("线程" + Thread.currentThread().getName() +
								"已离开，当前有" + (3-sp.availablePermits()) + "个并发");
					} catch (InterruptedException e) {
					}
				}
			};
			exec.execute(rb);
		}

		// 退出线程池
		exec.shutdown();
	}

}
