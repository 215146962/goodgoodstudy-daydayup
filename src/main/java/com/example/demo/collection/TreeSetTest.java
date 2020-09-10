package com.example.demo.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new Person("a", 24, 'm'));
		ts.add(new Person("c", 25, 'f'));
		ts.add(new Person("f", 26, 'm'));
		ts.add(new Person("g", 27, 'f'));
		ts.add(new Person("d", 28, 'm'));
		ts.add(new Person("h", 29, 'f'));
		ts.add(new Person("i", 30, 'm'));
		ts.add(new Person("h", 31, 'm'));

		for (Object object : ts) {
			Person p = (Person) object;
			System.out.println("[" + p.getName() + "," + p.getAge() + "," + p.getSex() + "]");
		}

	}
}
