package com.example.demo.AQS;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo1 extends Thread{

	/*
	 * 1.parties，如果因为某种原因导致没有足够多的线程来调用await，
	 * 这个时候会导致所有线程都会被阻塞
	 * 2.await(timeout,unit)设置一个超时等待时间,超时会抛出brokenBarrierException并停止阻塞
	 * 3.reset重置计数，抛出brokenBarrierException并停止阻塞
	 */
	public static void main(String[] args) {
		
		//parties=3代表参与者必须有三个阻塞才可以
		CyclicBarrier cyclicBarrier=new CyclicBarrier(3,new CyclicBarrierDemo1());
		
		new DataImportThread("path1",cyclicBarrier).start();
		new DataImportThread("path2",cyclicBarrier).start();
		new DataImportThread("path3",cyclicBarrier).start();
		//希望三个线程执行结束之后，再做一个汇总处理
		//cyclicBarrier.reset();
		
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("开始进行数据汇总和分析");
		
	}

}
