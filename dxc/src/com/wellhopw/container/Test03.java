package com.wellhopw.container;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * <p>Title: Test03.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年3月5日  
 * @version 1.0  
 * queue:队列  英 [kjuː] 美 [kju] 
 * 
 * 3.1ConcurrentLinkedQueue
 * 		基础链表同步队列  
 * 3.2LinkedBlockingDeque
 * 		阻塞队列，队列内容不足自动阻塞，队列容量为0自动阻塞。
 * 3.3ArrayBlockingQueue
 * 		底层数组实现的有界队列。自动阻塞。根据调用API（add/put/offer）不同，有不同特性。
 * 3.4DelayQueue
 * 		延时队列。根据比较极致，实现自定义处理顺序的队列。常用于定时任务。
 * 下表显示了jdk1.5中的阻塞队列的操作：
	　　add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
	　　remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
	　　element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
	　　offer       添加一个元素并返回true       如果队列已满，则返回false
	　　poll         移除并返问队列头部的元素    如果队列为空，则返回null
	　　peek       返回队列头部的元素             如果队列为空，则返回null
	　　put         添加一个元素                      如果队列满，则阻塞
	　　take        移除并返回队列头部的元素     如果队列为空，则阻塞
	
	 remove、element、offer 、poll、peek 其实是属于Queue接口。 
 *
 */
public class Test03 {
//	Queue<String> q1 = new ConcurrentLinkedQueue<String>();
//	Queue<String> q2 = new LinkedBlockingDeque<String>();
//	Queue<String> q3 = new ArrayBlockingQueue<String>(2);
//	Queue<String> q4 = new DelayQueue<String>();
	
	//FIFO
	public static void main(String[] args) {
		Queue<String> q = new ConcurrentLinkedQueue<String>();
		for (int i = 0; i < 10; i++) {
			q.offer("value:"+i);
		}
		System.out.println(q);
		System.out.println(q.size());
		
		System.out.println(q.peek());//返回队列头部的元素             如果队列为空，则返回null
		System.out.println(q.size());
		
		System.out.println(q.poll());//移除并返问队列头部的元素    如果队列为空，则返回null
		System.out.println(q.size());
		
	}
	
	
	
}
