package com.example.demo.thread;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		// 模拟电影票购票过程
		SaleTickets st1 = new SaleTickets();
		SaleTickets st2 = new SaleTickets();
		SaleTickets st3 = new SaleTickets();
		SaleTickets st4 = new SaleTickets();
		st1.setName("窗口1");
		st2.setName("窗口2");
		st3.setName("窗口3");
		st4.setName("窗口4");
		st1.start();
		st2.start();
		st3.start();
		st4.start();
	}

}

class SaleTickets extends Thread {

	// 电影票的数量
	static int tickets = 100;

	@Override
	public void run() {
		while (tickets > 0) {

			System.out.println(new Date() + "在" + getName() + "卖出了第" + tickets-- + "张票");
			
		}
	}
}