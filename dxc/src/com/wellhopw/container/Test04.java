package com.wellhopw.container;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test04.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年3月5日  
 * @version 1.0  
 * LinkedBlockingDeque
 *
 */
public class Test04 {
	/**
	　　add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
	　　remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
	　　element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
	　　offer       添加一个元素并返回true       如果队列已满，则返回false
	　　poll         移除并返问队列头部的元素    如果队列为空，则返回null
	　　peek       返回队列头部的元素             如果队列为空，则返回null
	　　put         添加一个元素                      如果队列满，则阻塞
	　　take        移除并返回队列头部的元素     如果队列为空，则阻塞 
	
	   remove、element、offer 、poll、peek 其实是属于Queue接口。
	    
	 */
	final BlockingQueue<String> q = new LinkedBlockingDeque<String>();
	final Random r = new Random();
	public static void main(String[] args) {
		final Test04 t = new Test04();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						t.q.put("value:"+t.r.nextInt(1000));
						System.out.println("~~~~~~~~~~~~~~~~put~~~~~~~~~~~~~~~~~~~~~~");
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "producer").start();
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							System.out.println(Thread.currentThread().getName()+" -- "+t.q.take());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}, "consumer"+i).start();
		}
		
	}
}
