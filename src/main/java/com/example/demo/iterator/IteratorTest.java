package com.example.demo.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//iterator一般用来遍历删除
public class IteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		addObject(list);
		printList(list);
		//建立迭代器，把list里数字2干掉
		Iterator iterator=list.iterator();
		while (iterator.hasNext()) {
			Object object=iterator.next();
			if (object.toString().equals("2")) {
				iterator.remove();
			}
		}
		printList(list);
	}

	//输出print list
	public static void printList(List list) {
		for (Object object:list) {
			System.out.print(object.toString()+" ");
		}
		System.out.println();
	}
	
	//给list添加一些数据
	public static void addObject(List list) {
		list.add("data1");
		list.add(2);
		list.add(new Object());
		list.add("4");
	}
	
}
