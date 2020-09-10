package com.example.demo.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo implements Runnable{

	public static void main(String[] args) {
		//ExecutorService executorService=ExecutorsSelf.newFixedThreadPool(3);
		ThreadPoolExecutor executorService=(ThreadPoolExecutor) ExecutorsSelf.newFixedThreadPool(3);
		executorService.prestartAllCoreThreads();//提前预热所有核心线程
		
		for (int i = 0; i < 100; i++) {
			executorService.execute(new ThreadPoolDemo());
		}
		executorService.shutdown();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
	}

}
