package com.example.demo.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
	private static AtomicInteger atomicInteger=new AtomicInteger(0);
	private static int count=0;
	
	public static void main(String[] args) throws InterruptedException {
		//使用原子性的类AtomicInteger保证原子性操作
		for (int i = 0; i < 1000; i++) {
			new Thread() {
				@Override
				public void run() {
					AtomicDemo.incr1();
				};
			}.start();
		}
		Thread.sleep(3000);
		System.out.println("atomicInteger result:"+atomicInteger.get());
		
		//非原子性操作
		for (int i = 0; i < 1000; i++) {
			new Thread() {
				@Override
				public void run() {
					AtomicDemo.incr2();
				};
			}.start();
		}
		Thread.sleep(3000);
		System.out.println("count result:"+count);
	}
	
	public static void incr1() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		atomicInteger.incrementAndGet();
	}
	
	public static void incr2() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
	}
}
