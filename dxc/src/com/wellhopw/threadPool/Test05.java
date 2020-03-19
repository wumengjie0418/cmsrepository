package com.wellhopw.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test05.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年3月6日  
 * @version 1.0  
 *
 */
public class Test05 {
	/**
	 * ScheduledThreadPool:定时任务线程池
	 * 
	 */
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		final List<String> list = new ArrayList<String>();
//		final List<String> list = new Vector<String>();
		final CountDownLatch latch = new CountDownLatch(1000);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			service.execute(new Runnable() {
				public void run() {
//					try {
//						TimeUnit.MILLISECONDS.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName()+"~~~~~~~~~~~66666666666666");
					list.add(Thread.currentThread().getName());
					latch.countDown();
				}
			});
		}
		service.shutdown();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(list.size());
		System.out.println(Thread.currentThread().getName()+"~~~~~~~~~~~over");
	}
	
}
