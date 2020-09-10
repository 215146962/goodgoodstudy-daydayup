package com.example.demo.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class DataImportThread extends Thread {
	
	private String path;
	private CyclicBarrier cyclicBarrier;
	
	public DataImportThread(String path,CyclicBarrier cyclicBarrier) {
		super();
		this.path = path;
		this.cyclicBarrier=cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("开始导入："+path+" 位置的数据");
		try {
			cyclicBarrier.await();//阻塞
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":汇总结束");
	}
}
