package com.example.demo.thread;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) {
		// 模拟电影购票
		// 创建Runnable实现类对象
		Runnable2 r1 = new Runnable2();
		// 创建一个Thread的具体类，并将Runnable具体实现类对象传入
		Thread t1 = new Thread(r1, "Van♂");
		Thread t2 = new Thread(r1, "Bili");
		Thread t3 = new Thread(r1, "MuJi");
		t1.start();
		t2.start();
		t3.start();
	}

}

class Runnable2 implements Runnable {

	int tickets = 1000;

	// 锁对象
	Lock lock = new ReentrantLock();

	@Override
	public void run() {
		while (tickets > 0) {
			//锁开始
			lock.lock();
			if (tickets > 0) {
				// 由于Runnable接口没有Thread的getName方法，所以用Thread.currentThread().getName()获取执行时线程的名称
				System.out.println(new Date() + "在" + Thread.currentThread().getName() + "卖出了第" + tickets-- + "张票");
			}
			//锁释放
			lock.unlock();
		}
	}

}
