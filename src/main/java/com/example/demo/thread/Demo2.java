package com.example.demo.thread;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		Thread02 t1 = new Thread02();
		Thread02 t2 = new Thread02();
		t1.setName("污妖王");
		t2.setName("伊利丹");
		t1.start();
		t2.start();
		Thread.sleep(500);
		t1.interrupt();
		t2.interrupt();
	}

}

class Thread02 extends Thread {
	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}