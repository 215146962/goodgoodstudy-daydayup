package com.example.demo.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionDemoNotify extends Thread{
	private Lock lock;
	private Condition condition;
	
	public ConditionDemoNotify(Lock lock, Condition condition) {
		super();
		this.lock = lock;
		this.condition = condition;
	}
	
	/*
	 * synchronized(class){
	 *    class.notify();
	 * } 
	 */
	@Override
	public void run() {
		System.out.println("begin - ConditionDemoNotify");
		try {
			lock.lock();
			condition.signal();
			System.out.println("end - ConditionDemoNotify");
		} finally {
			lock.unlock();
		}
	}
}
