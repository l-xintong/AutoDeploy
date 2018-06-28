package com.autoDeploy.ThreadDemo;




import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketThread implements Runnable {

	private int  count = 100;// 总的票数，这个是共享资源，多个线程都会访问
	//ReentrantLock Lock的实现重入锁，ReentrantLock(true)公平锁，ReentrantLock(fales)非公平锁，性能高于公平锁
	//ReentrantReadWriteLock读写锁
	/*
	 * 前面提到的ReentrantLock是排他锁，该锁在同一时刻只允许一个线程来访问，而读写锁在同一时刻允许可以有多个线程来访问，但在写线程访问时，
	 * 所有的读线程和其他写线程被阻塞。读写锁维护了一对锁，一个读锁和一个写锁，通过读写锁分离，使得并发性相比一般的排他锁有了很大的提升。
	*/
	private Lock lock = new ReentrantLock();

	private Map<String,Object> map = new ConcurrentHashMap<>();



	@Override
	public void run() {
		while (count>0){
			 sellTicket();
			try {
				Thread.sleep(100);
			}catch (Exception e){
				e.getStackTrace();
			}
		}

	}


	public synchronized  void  sellTicket() {
		//lock.lock();
		try {
			{
				if (count > 0) {
					count--;
					System.out.println(Thread.currentThread().getName() + "正在卖票,还剩" + count + "张票");
					map.put("id"+count,Thread.currentThread().getId());
					for(String key:map.keySet()){
						System.out.println("key="+key+"and value=" +map.get(key));
					}

				} else {
					System.out.println("票已经卖完！");
					return;
				}
			}
		}catch (Exception e){
			e.getStackTrace();
		}finally {
			//lock.unlock();
		}
	}

	}
