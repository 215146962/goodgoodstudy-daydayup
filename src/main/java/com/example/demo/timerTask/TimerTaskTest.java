package com.example.demo.timerTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 介绍一下FutureTask
 * 一个类首先实现Callable
 * 然后把这个类扔进FutureTask的构造方法里构造出futureTask对象
 * 再executorService.submit(futureTask)就可以执行线程
 * 也可以Thread thread = new Thread(futureTask);执行线程
 */
/**
 * 
 * Runnable接口中的run()方法的返回值是void，它做的事情只是纯粹地去执行run()方法中的代码而已；
 * Callable接口中的call()方法是有返回值的，是一个泛型，和Future、FutureTask配合可以用来获取异步执行的结果。
 */

//使用Future对象获取线程的返回值
public class TimerTaskTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程池
		ExecutorService threadPool=Executors.newCachedThreadPool();
		//创建Callable
		Callable callable=new Callable() {
			@Override
			public String call() throws Exception {
				System.out.println("现在在Callable中，时间："+getStringDate());
				Thread.sleep(3000);
				return "callable返回值";
			}
		};
		//开始线程
		Future<String> future=threadPool.submit(callable);
		
		System.out.println("返回前，时间："+getStringDate());
		System.out.println("获取返回值："+future.get());
		System.out.println("返回后，时间："+getStringDate());
		System.out.println("------------------------------");
		
		
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				System.out.println("把Runnable扔进线程池执行的结果");
				
			}
		};
		threadPool.execute(runnable);
		//记得shutdown，不然程序会继续运行
		threadPool.shutdown();
		
	}
	
	//获取当前系统时间
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
}
