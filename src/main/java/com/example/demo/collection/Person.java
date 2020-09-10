package com.example.demo.collection;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private char sex;

	public Person(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("进入equal了");
		Person p = (Person) obj;
		if (name.equals(p.getName())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		System.out.println(Objects.hashCode(name));
		return Objects.hashCode(name);
	}

	@Override
	public int compareTo(Person o) {
		if (name.compareTo(o.getName())==0) {
			return 0;
		}else {
			return name.compareTo(o.getName());
		}
	}

}
