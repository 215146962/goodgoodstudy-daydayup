package com.example.demo.dateDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
		long second = date.getTime();
		System.out.println(second);
		Date date2 = new Date(second);
		System.out.println(date2.toString());

		// 格式化Date格式
		System.out.println("-----------------------开始格式化Date输出格式");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		System.out.println("目前输出的格式为：" + simpleDateFormat.toPattern());
		System.out.println("重新设置输出格式为：yyyy年MM月dd日hh:mm:ss");
		simpleDateFormat.applyPattern("yyyy年MM月dd日hh:mm:ss");
		String string = simpleDateFormat.format(date2);
		System.out.println(string);

		// 解析符合条件的日期
		System.out.println("-----------------------解析符合日期格式的字符串");
		string = "2020年02月11日11:11:11";
		System.out.println("要解析的日期字符串为：" + string);
		Date date3 = null;
		try {
			date3 = simpleDateFormat.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date3);
		System.out.println(simpleDateFormat.format(date3));

	}

}
