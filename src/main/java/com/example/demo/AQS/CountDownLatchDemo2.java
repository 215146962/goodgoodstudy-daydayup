package com.example.demo.AQS;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 implements Runnable{

	static CountDownLatch countDownLatch=new CountDownLatch(1);
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(new CountDownLatchDemo2()).start();
		}
		//这里建好1000个线程之后子线程开始同时执行
		//子线程countDownLatch.await()阻塞，等待主线程执行countDownLatch.countDown()
		countDownLatch.countDown();
	}

	@Override
	public void run() {
		try {
			countDownLatch.await();
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
