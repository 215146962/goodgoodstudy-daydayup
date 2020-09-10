package com.example.demo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		List list=new ArrayList<Integer>();
		list.add(2);
		list.add(55);
		list.add(43);
		list.add(37);
		list.add(16);
		System.out.println(list);
		
		//集合的工具类
		//自然排序
		System.out.println("-------------自然排序");
		Collections.sort(list);
		System.out.println(list);
		//二分查找
		System.out.println("-------------二分查找");
		int s=Collections.binarySearch(list, 37);
		System.out.println("查找数字37在list中的位置是："+s);
		//查找最大值
		System.out.println("-------------查找最大值");
		System.out.println("集合最大值："+Collections.max(list));
		//元素反转
		System.out.println("-------------元素反转");
		Collections.reverse(list);
		System.out.println(list);
		//元素随机
		System.out.println("-------------元素随机");
		Collections.shuffle(list);
		System.out.println(list);
		//将返回一个线程安全的集合
		System.out.println("-------------线程安全");
		List list2=Collections.synchronizedList(list);
		System.out.println(list2);
	}

}
