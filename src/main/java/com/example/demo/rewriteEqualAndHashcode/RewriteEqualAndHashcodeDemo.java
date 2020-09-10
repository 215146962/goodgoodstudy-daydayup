package com.example.demo.rewriteEqualAndHashcode;

import java.util.HashSet;
import java.util.Set;

public class RewriteEqualAndHashcodeDemo {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(1, "小霸王"));
		set.add(new Student(151, "小志龙"));
		set.add(new Student(521, "小汉东"));
		set.add(new Student(43, "小懋坤"));
		set.add(new Student(64, "小飞机"));
		set.add(new Student(44, "小帅锅"));
		set.add(new Student(44, "小美铝"));	//这里无法添加进set中，也无法覆盖。只要set中判断有相同对象，就会拒绝新对象进入
		System.out.println(set.size());
		for (Object obj : set) {
			Student student = (Student) obj;
			System.out.println(student.getName());
		}
	}

}
