package com.example.demo.thread;

import java.util.Date;

/**
 * 创建线程有两种方式，继承Thread和实现Runnable接口，但一般推荐使用实现Runnable接口的方式
 * 1.因为java中只能继承一个类，如果有一个类继承了其他类的同时又想实现多线程，就只能使用实现Runnable接口的方式
 * 2.代码更加合理，因为一个类要实现多线程就必须重写run方法，而实现接口会强制我们必须重写
 * 3.当多个线程需要共享线程对象的某一个数据的时候，Runnable不需要使用静态修饰，因为Runnable的实现类只有一个，而所有
 * Thread都是共享一个Runnable实现对象
 * 
 * @author 21514
 *
 */

public class RunnableDemo {

	public static void main(String[] args) {

		// 模拟电影购票
		// 创建Runnable实现类对象
		Runnable1 r1 = new Runnable1();
		// 创建一个Thread的具体类，并将Runnable具体实现类对象传入
		Thread t1 = new Thread(r1, "Van♂");
		Thread t2 = new Thread(r1, "Bili");
		Thread t3 = new Thread(r1, "MuJi");
		t1.start();
		t2.start();
		t3.start();
	}

}

class Runnable1 implements Runnable {

	int tickets = 1000;

	// 锁对象
	Object obj = new Object();

	@Override
	public void run() {
		while (tickets > 0) {
			synchronized (obj) {
				if (tickets > 0) {
					// 由于Runnable接口没有Thread的getName方法，所以用Thread.currentThread().getName()获取执行时线程的名称
					System.out.println(new Date() + "在" + Thread.currentThread().getName() + "卖出了第" + tickets-- + "张票");
				}
			}
		}
	}

}
