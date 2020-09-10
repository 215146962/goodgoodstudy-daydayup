package com.example.demo.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	
	public static void main(String[] args) {
		Lock lock=new ReentrantLock();
		Condition condition=lock.newCondition();
		ConditionDemoWait conditionDemoWait=new ConditionDemoWait(lock, condition);
		ConditionDemoNotify conditionDemoNotify=new ConditionDemoNotify(lock, condition);
		conditionDemoWait.start();
		conditionDemoNotify.start();
	}
}
