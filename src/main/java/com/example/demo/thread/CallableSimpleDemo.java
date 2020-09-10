package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableSimpleDemo implements Callable<String> {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService=Executors.newFixedThreadPool(1);
		Future<String> future =executorService.submit(new CallableSimpleDemo());
		//future.get()是一个阻塞方法
		System.out.println(Thread.currentThread()+"-"+future.get());
		//如果不执行shutdown()方法，程序会继续运行
		executorService.shutdown();
		
		System.out.println("------------不使用线程池执行Callable");
		FutureTask<String> futureTask=new FutureTask<String>(new CallableSimpleDemo());
		new Thread(futureTask).start();;
		System.out.println(futureTask.get());
	}

	@Override
	public String call() throws Exception {
		System.out.println("当前线程："+Thread.currentThread().getName());
		return "Hello Mic";
	}

}
