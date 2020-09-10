package com.example.demo.rewriteEqualAndHashcode;

import java.util.Objects;

public class Student {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Student student = (Student) obj;
		if (id == student.getId()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(id);
	}
}
