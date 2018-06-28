package com.autoDeploy.service.Impl.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountDownLatchTest {

	@Test
	public  void  countDL(){

		final CountDownLatch countDownLatch = new CountDownLatch(2);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("进入线程t1  等待其他线程处理完成……");
					countDownLatch.await();
					System.out.println("t1线程继续执行……");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t1").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("进入线程t3进行初始化操作……");
					Thread.sleep(2000);
					System.out.println("t3线程执行完毕。。。");
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		},"t2").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("进入线程t2进行初始化操作……");
					Thread.sleep(4000);
					System.out.println("t2线程执行完毕。。。");
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t3").start();

	}

/**
 * 执行结果如下：
 进入线程t1  等待其他线程处理完成……
 进入线程t3进行初始化操作……
 进入线程t2进行初始化操作……
 t3线程执行完毕。。。
 t2线程执行完毕。。。
 t1线程继续执行……


 *分析CountDownLatch：
 运行程序我们会发现当我们在t1调用CountDownLatch的await()方法时，就好比我们调用了wait()方法，当前线程会处于阻塞状态，
 直到等到t2和t3完全执行完毕并且调用countDown()方法时，我们才能唤醒t1继续进行执行，CountDownLatch就好比一个计时器，
 我们可以让当前线程调用CountDownLatch中的await()方法进行等待，如果想让当前线程继续执行，我们必须让CountDownLatch
 获得初始化时候传入的构造参数个countDown()方法，我们才能继续执行。

 *CountDownLatch的使用场景：
 在一些应用场合中，需要等待某个条件达到要求后才能做后面的事情；同时当线程都完成后也会触发事件，以便进行后面的操作。 这个时候
 就可以使用CountDownLatch。CountDownLatch最重要的方法是countDown()和await()，前者主要是倒数一次，后者是等待倒数到0，
 如果没有到达0，就只有阻塞等待了。
 */

}
