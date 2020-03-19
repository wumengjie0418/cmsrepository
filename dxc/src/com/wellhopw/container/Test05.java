package com.wellhopw.container;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test05.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年3月5日  
 * @version 1.0  
 * ArrayBlockingQueue:底层数组实现的有界队列。自动阻塞。根据调用API（add/put/offer）不同，有不同特性。
 *
 */
public class Test05 {
	final BlockingQueue<String> q = new ArrayBlockingQueue<String>(3);
	final Random r = new Random();
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
	public static void main(String[] args) {
		Test05 t = new Test05();
		for (int i = 0; i < 5; i++) {
			//　add        增加一个元索             如果队列已满，则抛出一个IIIegaISlabEepeplian异常
//			System.out.println("add method : "+ t.q.add("value:"+i));
			
//			put         添加一个元素                      如果队列满，则阻塞
//			try {
//				t.q.put("value:"+i);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("put method : " + i);
			
//			offer       添加一个元素并返回true       如果队列已满，则返回false
			//第一种：单参数不阻塞
//			System.out.println("offer method : " + t.q.offer("value:"+i));
			//第二种：三参数方法，定时阻塞。
			try {
				System.out.println("offer method : " + t.q.offer("value:"+i, 1 ,TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		System.out.println(t.q);
	}
}
