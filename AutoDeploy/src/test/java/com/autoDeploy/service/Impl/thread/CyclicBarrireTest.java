package com.autoDeploy.service.Impl.thread;

import com.google.common.util.concurrent.Atomics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CyclicBarrireTest {

	@Test
	public void CyclicTest() {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		try {
			executorService.execute(new Runner(cyclicBarrier, "张三"));
			executorService.execute(new Runner(cyclicBarrier, "李四"));
			executorService.execute(new Runner(cyclicBarrier, "王五"));
		} finally {
			executorService.shutdown();
		}


	}

	/**
	 * 执行结果如下：
	 pool-1-thread-1已经准备好
	 pool-1-thread-3已经准备好
	 pool-1-thread-2已经准备好
	 pool-1-thread-2出发！！
	 pool-1-thread-1出发！！
	 pool-1-thread-3出发！！

	 * CyclicBarrier 分析结果：
	 上述程序我们创建了一个线程池，这个线程池中有三个线程，每个线程都传递了一个相同的CyclicBarrier 对象和运动员的名字，
	 我们Runner类中的run方法使每一个进来的运动员都休眠0-5秒的时间，然后调用await()方法，就是说每个线程进来都需要进行等待，
	 直到所有的CyclicBarrier 都处于准备好了的状态，所有线程才能统一开始执行！

	 * CyclicBarrier 使用场景
	 CyclicBarrier可以用于多线程计算数据，最后合并计算结果的应用场景。比如我们用一个Excel保存了用户所有银行流水，每个Sheet保存
	 一个帐户近一年的每笔银行流水，现在需要统计用户的日均银行流水，先用多线程处理每个sheet里的银行流水，都执行完之后，得到每个sheet
	 的日均银行流水，最后，再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流水。
	 三.cyclicBarrier和CountDownLatch的区别
	 1、CountDownLatch简单的说就是一个线程等待，直到他所等待的其他线程都执行完成并且调用countDown()方法发出通知后，当前线程才可以继续执行。
	 2、cyclicBarrier是所有线程都进行等待，直到所有线程都准备好进入await()方法之后，所有线程同时开始执行！
	 3、CountDownLatch的计数器只能使用一次。而CyclicBarrier的计数器可以使用reset() 方法重置。所以CyclicBarrier能处理更为复杂的业务场景，比如如果计算发生错误，可以重置计数器，并让线程们重新执行一次。
	 4,、CyclicBarrier还提供其他有用的方法，比如getNumberWaiting方法可以获得CyclicBarrier阻塞的线程数量。isBroken方法用来知道阻塞的线程是否被中断。如果被中断返回true，否则返回false。
	 */


}


