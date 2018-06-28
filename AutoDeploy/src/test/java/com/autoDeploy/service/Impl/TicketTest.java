package com.autoDeploy.service.Impl;



import com.autoDeploy.ThreadDemo.TicketThread;
import org.apache.http.client.utils.CloneUtils;

import java.util.concurrent.BlockingQueue;


public class TicketTest {

	public static void main(String[] args) {
		TicketThread runTicekt = new TicketThread();
		Thread th1 = new Thread(runTicekt, "窗口1");
		Thread th2 = new Thread(runTicekt, "窗口2");
		Thread th3 = new Thread(runTicekt, "窗口3");
		Thread th4 = new Thread(runTicekt, "窗口4");
		Thread th5 = new Thread(runTicekt, "窗口5");


		Thread th = new Thread(runTicekt, "窗口1");
		th1.setPriority(Thread.NORM_PRIORITY+2);//设置线程的优先级


		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();





	}

}