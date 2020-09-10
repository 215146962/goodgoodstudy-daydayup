package com.example.demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * Interface Stream<T>
 * 顺序流：default Stream<E>;
 * 并行流：default parallelStream<E>;
 */

public class StreamDemo1 {

	public static void main(String[] args) {
		// 准备好数据源
		List<Emp> list = new ArrayList<Emp>();
		Emp e1 = new Emp("马化腾", 19000, 1);
		Emp e2 = new Emp("雷军", 19234, 2);
		Emp e3 = new Emp("求伯君", 200, 3);
		Emp e4 = new Emp("丁磊", 4320, 4);
		Emp e5 = new Emp("Van", 1684, 5);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		// 获取流
		Stream<Emp> stream = list.stream();

		// 查询所有员工工资大于7000的员工
		stream.filter(emp -> emp.getSalary() > 7000).forEach(System.out::println);
		// 只显示其中三个员工
		System.out.println("--------------------");
		stream = list.stream();
		stream.limit(3).forEach(System.out::println);
		// skip(Long n)跳过元素，返回一个扔掉了前n个元素的流，与limit(n)互补
		System.out.println("--------------------");
		stream = list.stream();
		stream.skip(3).forEach(System.out::println);
	}

}

class Emp {
	private String name;
	private double salary;
	private int number;

	public Emp(String name, double salary, int number) {
		super();
		this.name = name;
		this.salary = salary;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {

		return "[name=" + this.name + ",salary=" + this.salary + ",number=" + this.number + "]";
	}

}
