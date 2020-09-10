package com.example.demo.ThreadLocal;

import java.util.Random;

public class ThreadLocalDemo1 {
	public static Integer num=0;
	
	public static final ThreadLocal<Integer> local=new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;//初始值
		}
	};
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads=new Thread[5];
		for (int i = 0; i < 5; i++) {
			threads[i]=new Thread("Thread-"+i) {
				@Override
				public void run() {
					num=local.get();//拿到初始值
					num+=5;
					local.set(num);
					System.out.println(Thread.currentThread().getName()+"->"+num);
				};
			};
		}
		for (Thread thread : threads) {
			thread.start();
		}
	}
}
