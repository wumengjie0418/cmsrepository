package com.wellhopw.container;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyTask implements Delayed{

	private long compareValue;
	public MyTask(long compareValue){
		this.compareValue = compareValue;
	}
	
	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return (int)(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(compareValue - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString(){
		return "Task compare value is :" + this.compareValue;
	}

}
