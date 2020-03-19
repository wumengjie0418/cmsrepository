package com.wellhopw.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test03.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年3月6日  
 * @version 1.0  
 *
 */
public class Test03 {
	/**
	1.Executor
		线程池的顶级接口。定义方法void excute(Runnable)。方法是用于处理任务的一个服务方法。
		调用者提供Runnable接口实现，线程池通过线程执行Runnable。服务方法无返回值，应为run方法
		无返回值。
		作用：启动线程。
	2.ExecutorService
		Executor的子接口。
		提供了一个特有的服务方法，有返回值，submit
		重载方法中：Runnable 方法不提供返回值，Callable 提供了返回值
		常见方法：void excute(Runnable), Future submit(Callable), Future submit(Runnable)
		线程池状态：Running, ShuttingDown, Terminated
		Running:线程池活跃状态。
		ShuttingDown：线程池正在关闭过程中。优雅关闭，一旦进入这个状态，线程池不再接受新的任务，处理所有已经接收的任务。
					   处理完毕后，关闭线程池。
		Terminated：线程已经关闭，死亡状态。
		
		java.util.concurrent.ThreadPoolExecutor@5c647e05
			[Running, pool size = 3, active threads = 3, queued tasks = 2, completed tasks = 0]
		false
		true
		java.util.concurrent.ThreadPoolExecutor@5c647e05
			[Shutting down, pool size = 3, active threads = 3, queued tasks = 2, completed tasks = 0]
		pool-1-thread-2 test executor 
		pool-1-thread-3 test executor 
		pool-1-thread-1 test executor 
		pool-1-thread-3 test executor 
		pool-1-thread-2 test executor 
		true
		true
		java.util.concurrent.ThreadPoolExecutor@5c647e05
			[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 5]
	3.Future 
		未来结果，代表线程执行结束后的结果。
		常用方法：T.get(),阻塞等待;
			   T.get(long, TimeUnit),阻塞等待,超时抛出异常;
	4.Callable 
		可执行接口。类似于Runnable接口，也是启动一个线程的方法。提供了一个call方法，等同于run方法。
		返回值为Object
	5.Executors
		工具类
	*/
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(1);
		Future<String> submit = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				TimeUnit.SECONDS.sleep(1);
				System.out.println("aaaaaa");
				return Thread.currentThread().getName()+" test future ";
			}
		});
		System.out.println(submit);
		System.out.println(submit.isDone());//isDone(),查看线程是否执行完成，即call方法执行完毕。
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		try {
			System.out.println(submit.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(submit.isDone());
		
	}
	
	
	
}
