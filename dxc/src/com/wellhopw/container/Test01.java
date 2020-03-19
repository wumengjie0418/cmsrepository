package com.wellhopw.container;

import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test01.java</p>  
 * <p>Description: ThreadLocal</p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年3月4日  
 * @version 1.0  
 * 就是一個map，key --》Thread.getCurrentThread(). value --》 線程需要保存的變量
 * ThreadLocal.set(value)  ->  map.put(Thread.getCurrentThread(), value)
 * ThreadLocal.get()	   ->  map.get(Thread.getCurrentThread());
 * 内存问题：并发量高的时候可能出现溢出的问题。
 * 使用ThreadLocal的时候，一定要注意资源会搜狐问题，每个线程结束之前，将当前线线程的线程变量一定要删除
 * ThreadLocal.remove();否则虎刺弧线内存泄漏问题。
 * ThreadLocal的remove问题：
 *
 */
public class Test01 {
	volatile static String name = "zhangsan";
	static ThreadLocal<String> tl = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name);
				System.out.println(tl.get());
				tl.remove();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				name = "lisi";
				tl.set("sdfsdfdsfdsdfdsfdsfsdfsdf");
				tl.remove();
			}
		}).start();
	}
	
}
