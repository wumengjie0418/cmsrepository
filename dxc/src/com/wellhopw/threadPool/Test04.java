package com.wellhopw.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test04 {
	/**
	5.Executors 
		工具类。为Executor提供方法，能够快速的提供若干种线程。如
	固定容量的，无限容量的，容量为1的线程池。
		线程池是进程级别的重量级资源。默认的生命周期和JVM一致，当开启线程池的
	时候，知道JVM关闭为止，是线程池的默认生命周期。手动调用shutdown方法，所有
	线程执行完毕后，自动关闭。
	6.FixedThreadPool
		固定容量的线程池，有容量上限。所有的线程池中，都有一个任务队列，他是使用
	BlockingQueue<Runnable>为载体实现的。当任务数量大于线程池的容量的时候，
	没有运行的任务保存在任务队列中，当线程有空闲的时候，自动从队列中取出任务执行。
	queued tasks 任务队列
	completed tasks 结束任务队列
	
	使用场景：
		大多数情况下，使用线程池，首选推荐FixedThreadPool。因为os操作系统和
	硬件支持是有上限的。不能随意无限制的提供线程池。
		线程池上限为Integer.MAX_VALUE
	
	7.CachedThreadPool
		无限量容量线程池。线程池上限为Integer.MAX_VALUE 2^31，自动扩容。
		线程管理策略：线程池中的线程如果无法满足任务处理的话就会创建线程，当线程
	空闲时间达到上限(线程默认空闲60秒)，自动释放回收。
		应用场景：内部应用和测试用。测试性能，并发量。内部应用是，任务能够很快结束。
		
		
	*/	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service);
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
		try {
			TimeUnit.SECONDS.sleep(65);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(service);
	}
	
}
