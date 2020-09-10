package com.example.demo.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSelf extends ThreadPoolExecutor {

	//构造方法直接用父类的构造方法
	/*
	 * int corePoolSize 核心线程数
	 * int maximumPoolSize 最大线程数
	 * Long keepAliveTime 线程存活时间Long型（针对的是超过核心线程数的线程）
	 * TimeUnit unit 时间单位，keepAliveTime的时间单位
	 * BlockingQueue<Runnable> workQueue 任务队列
	 * 
	 */
	public ThreadPoolSelf(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public void shutdown() {
		super.shutdown();
	}
	
	//目的是重写beforeExecute和afterExecute
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
	}
	
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("初始线程数："+this.getPoolSize());
		System.out.println("核心线程数："+this.getCorePoolSize());
		System.out.println("正在执行的任务数量："+this.getActiveCount());
		System.out.println("已经执行的任务数："+this.getCompletedTaskCount());
		System.out.println("任务总数："+this.getTaskCount());
	}
	
}
