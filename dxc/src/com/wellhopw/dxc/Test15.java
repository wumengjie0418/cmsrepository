package com.wellhopw.dxc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test15.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年2月24日  
 * @version 1.0  
 * 
 * 门栓可以和锁使用，或替代锁的。
 * 在门闩未开放之前等待，开放之后放行。
 * 避免锁的效率低下问题。
 * 
 *
 */
public class Test15 {
	CountDownLatch latch = new CountDownLatch(5);
	
	void m1(){
		try {
			latch.await();//等待门闩开放
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1()~~~~~method");
	}
	
	void m2(){
		for (int i = 0; i < 10; i++) {
			if (latch.getCount() != 0) {
				System.out.println("latch count:"+latch.getCount());
				latch.countDown();//门栓上减锁
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m2() method:"+i);
		}
	}
	
	public static void main(String[] args) {
		final Test15 t = new Test15();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m1();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m2();
			}
		}).start();
		
	}
	
}
