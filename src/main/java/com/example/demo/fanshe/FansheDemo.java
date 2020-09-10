package com.example.demo.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FansheDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// 获取一个类对象
		Class<Person> clazz = Person.class;
		// 获取类对象对应的属性或方法
		System.out.println(clazz.getName());
		System.out.println(clazz.getPackage());
		System.out.println(clazz.getClassLoader());
		System.out.println(clazz.getSuperclass());
		// Person person=clazz.newInstance();//获取一个实例对象,该方法被弃用
		/*
		 * 获取实例对象
		 */
		Constructor<Person> constructor = null;
		try {
			constructor = clazz.getConstructor();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		Person person = constructor.newInstance();
		System.out.println(person);

		// 获取类型中的方法
		Method method = clazz.getDeclaredMethod("jump");
		//通过反射执行方法
		method.invoke(person);

	}

}

class Person {
	
	public Person() {
	}

	public void jump() {
		System.out.println("芜湖，跳起来了");
	}
}