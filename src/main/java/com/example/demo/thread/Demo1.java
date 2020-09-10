package com.example.demo.thread;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		Thread01 t1 = new Thread01();
		Thread01 t2 = new Thread01();
		Thread01 t3 = new Thread01();
		t1.setName("van");
		t2.setName("bili");
		t3.setName("首先执行的线程");
		t1.setPriority(5);
		t2.setPriority(10);
		t3.setPriority(1);
		t3.start();
		t3.join();// t3执行完后才执行下面的步骤
		
		t1.setDaemon(true);//把t1设为守护线程，它会在所有用户线程结束后再结束
		t1.start();
		t2.start();

		Thread thread3 = Thread.currentThread();
		System.out.println(thread3.getName());
	}

}

class Thread01 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + ":" + i);
			Thread.yield();// 让当前正在运行的线程回到可运行状态，重新与其他线程竞争（简单来说就是让cpu分配得更均匀）
		}
	}
}
