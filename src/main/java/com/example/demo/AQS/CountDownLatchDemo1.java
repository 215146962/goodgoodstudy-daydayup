package com.example.demo.AQS;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo1 {

	public static void main(String[] args) throws InterruptedException {
		//初始化要数数3次
		CountDownLatch countDownLatch = new CountDownLatch(3);

		//每执行一次countDownLatch.countDown()就会减1
		new Thread() {
			public void run() {
				countDownLatch.countDown();
			};
		}.start();
		new Thread() {
			public void run() {
				countDownLatch.countDown();
			};
		}.start();
		/*new Thread() {
			public void run() {
				countDownLatch.countDown();
			};
		}.start();*/
		//这里会一直阻塞，除非执行了三次countDownLatch.countDown()
		//最后一次countDownLatch.countDown()触发唤醒操作
		countDownLatch.await();
		System.out.println("线程执行完毕");

	}

}
