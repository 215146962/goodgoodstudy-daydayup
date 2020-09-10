package com.example.demo.match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDemo {

	public static void main(String[] args) {

		// 简单判断字符串合不合法
//		Scanner sc = new Scanner(System.in);
//		String pattern = "^1[3|4|5|7|8][0-9]{9}$"; // 正则表达式
//		System.out.println("请输入手机号码：");
//		String qqNum = sc.next();
//		if (Pattern.matches(pattern, qqNum)) {
//			System.out.println("手机号码合法");
//		} else {
//			System.out.println("手机号码不合法");
//		}

		// 捕获字符串
		// 普通捕获组
		System.out.println("普通捕获组-----------------");
		String string1 = "2020-06-282020-06-29";
		String regex1 = "(\\d{4})-((\\d{2})-(\\d{2}))";
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(string1);
		while (matcher1.find()) {// 假如是很长的字符串有多个匹配的字符串，就可以循环匹配
			System.out.printf("matcher.group(0) value:%s", matcher1.group(0));
			System.out.printf("\nmatcher.group(1) value:%s", matcher1.group(1));
			System.out.printf("\nmatcher.group(2) value:%s", matcher1.group(2));
			System.out.printf("\nmatcher.group(3) value:%s", matcher1.group(3));
			System.out.printf("\nmatcher.group(4) value:%s\n", matcher1.group(4));
		}
		// 命名捕获组
		System.out.println("命名捕获组-----------------");
		String string2 = "2020-06-282020-06-29";
		String regex2 = "(?<year>\\d{4})-(?<md>(?<month>\\d{2})-(?<date>\\d{2}))";
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(string2);
		System.out.printf("\n===========使用名称获取=============");
		while (matcher2.find()) { 
			System.out.printf("\nmatcher.group(0) value:%s", matcher2.group(0));
			System.out.printf("\n matcher.group('year') value:%s", matcher2.group("year"));
			System.out.printf("\nmatcher.group('md') value:%s", matcher2.group("md"));
			System.out.printf("\nmatcher.group('month') value:%s", matcher2.group("month"));
			System.out.printf("\nmatcher.group('date') value:%s", matcher2.group("date"));
		}
		matcher2.reset();
		System.out.printf("\n===========使用编号获取=============");
		while (matcher2.find()) {
			System.out.printf("\nmatcher.group(0) value:%s", matcher2.group(0));
			System.out.printf("\nmatcher.group(1) value:%s", matcher2.group(1));
			System.out.printf("\nmatcher.group(2) value:%s", matcher2.group(2));
			System.out.printf("\nmatcher.group(3) value:%s", matcher2.group(3));
			System.out.printf("\nmatcher.group(4) value:%s", matcher2.group(4));
		}
	}

}
