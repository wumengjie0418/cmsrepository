package com.wellhopw.container;

import java.util.Queue;
import java.util.concurrent.DelayQueue;

/**
 * @author WuMJ
 * <p>Title: Test06.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020年3月5日  
 * @version 1.0  
 * 
 *
 */
public class Test06 {
	//DelayQueue:延时队列。根据比较极致，实现自定义处理顺序的队列。常用于定时任务。
	final Queue<MyTask> queue = new DelayQueue<MyTask>();
	public static void main(String[] args) {
		
	}
}
