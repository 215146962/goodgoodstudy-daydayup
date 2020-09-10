package com.example.demo.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionDemoWait extends Thread{
	private Lock lock;
	private Condition condition;
	
	public ConditionDemoWait(Lock lock, Condition condition) {
		super();
		this.lock = lock;
		this.condition = condition;
	}

	/*
	 * synchronized(class){
	 *    class.wait();
	 * } 
	 */
	@Override
	public void run() {
		System.out.println("begin - ConditionDemoWait");
		try {
			lock.lock();
			condition.await();
			System.out.println("end - ConditionDemoWait");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
