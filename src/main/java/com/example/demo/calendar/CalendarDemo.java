package com.example.demo.calendar;

import java.util.Calendar;
import java.util.Scanner;

//日历工具用法
public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance(); // 单例设计模式
		// 获取年份
		System.out.println(calendar.get(Calendar.YEAR));
		// 获取月份，月份从0开始，所以要加1
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		// 获取日
		System.out.println(calendar.get(Calendar.DATE));

		// 五年后的十天前日期
		calendar.add(Calendar.YEAR, 5);
		calendar.add(Calendar.DATE, -10);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		System.out.println(calendar.get(Calendar.DATE));

		// 输入年份算出二月有多少天
		System.out.println("请输入年份：");
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		calendar.set(year, 2, 1); // 这一天是那年的三月1日
		calendar.add(Calendar.DATE, -1); // 通过三月1日减一天得出二月的天数
		System.out.println(calendar.get(Calendar.DATE));

	}

}
