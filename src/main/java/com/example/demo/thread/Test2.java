package com.example.demo.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 模拟生产者和消费者（中间设置缓冲区）
 */

public class Test2 {

	public static void main(String[] args) {
		// 生产者和消费者公共区域（缓冲区）
		Queue<String> queue = new LinkedList<String>();

		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);

		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);

		t1.start();
		t2.start();

	}

}

class Producer implements Runnable {

	private Queue<String> queue;

	public Producer(Queue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (queue) {
				if (queue.size() >= 10) { // 假设队列最多放10个元素，则如果放满了10个，就让线程进入休眠状态
					try {
						queue.notifyAll();
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				String str = "产品" + i;
				System.out.println("生产者生产了" + str);
				queue.offer(str);
				queue.notifyAll();
			}
		}
	}

}

class Consumer implements Runnable {

	private Queue<String> queue;

	public Consumer(Queue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				// 判断队列是否为空
				if (!queue.isEmpty()) {
					String str = queue.poll();
					System.out.println("消费者拿到了" + str);
					queue.notifyAll();
				} else {
					// System.out.println("empty");
					queue.notifyAll();
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
