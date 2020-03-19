package com.wellhopw.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 
 * <p>Title: Test02.java</p>  
 * <p>Description: 线程池</p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年3月6日  
 * @version 1.0  
 * FixedThreadPool - 固定容量的线程池，创建时需要指定容量。
 * ExecutorService - 线程池服务类型。继承了Executor接口，所有的线程池都实现了这个接口。
 * 					  实现这个接口，代表可以提供线程池能力。
 * Executors - Executor的工具类。类似Collection和Collections的关系。
 * 			       可以更简单的创建若干种线程池。
 * shutdown:优雅关闭。不是强行关闭线程池，回收线程池中的资源。
 * 			而是不在接收新的任务，将已经接收的任务处理完毕以后再次关闭。
 *
 */
public class Test02 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			service.execute(new Runnable() {
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " test executor ");
				}
			});
		}
		System.out.println(service);
		service.shutdown();//之后任务不再处理。
		//是否已经结束，相当于回收了资源。
		System.out.println(service.isTerminated());
		//是否已经关闭，是否调用过shutDown方法
		System.out.println(service.isShutdown());
		System.out.println(service);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//是否已经结束，相当于回收了资源。
		System.out.println(service.isTerminated());
		//是否已经关闭，是否调用过shutDown方法
		System.out.println(service.isShutdown());
		System.out.println(service);
		
	}
}
