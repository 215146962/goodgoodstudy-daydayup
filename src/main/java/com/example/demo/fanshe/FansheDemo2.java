package com.example.demo.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class FansheDemo2 {

	/*
	 * Field操作
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class<User> userClass = User.class;
		// 获取User对象
		Constructor<User> constructor = userClass.getConstructor();
		User user = constructor.newInstance();
		// 获取类型中定义的字段 公有的字段以及父类中公有的字段
		Field[] field1 = userClass.getFields();
		for (Field field : field1) {
			System.out.println(field.getModifiers() + " " + field.getName());
		}
		System.out.println("----------------------------");
		// 获取当前类中公有的和私有的字段（不包括父类）
		Field[] field2 = userClass.getDeclaredFields();
		for (Field field : field2) {
			System.out.println(field.getModifiers() + " " + field.getName());
		}

		// 获取name字段对应的Field
		Field nameField = userClass.getDeclaredField("name");
		// 如果要操作私有属性信息那么我们需要放开权限
		nameField.setAccessible(true);
		nameField.set(user, "van♂");
		System.out.println(user.getName());
		// 对静态属性赋值
		Field addressField = userClass.getDeclaredField("address");
		addressField.set(null, "幻想乡");
		System.out.println(User.address);
		System.out.println("----------------------接下来是方法");
		//获取当前类及父类中所有的公有方法
		Method[] methods=userClass.getMethods();
		for(Method m:methods) {
			System.out.println(m.getModifiers()+" "+m.getName());
		}
		System.out.println("--------------------");
		//获取本类中所有的方法，包括私有的
		Method[] declaredMethods=userClass.getDeclaredMethods();
		for(Method m:declaredMethods) {
			System.out.println(m.getModifiers()+" "+m.getName());
		}
		
		Method jumpMethod=userClass.getDeclaredMethod("jump");
		//放开私有方法的调用
		jumpMethod.setAccessible(true);
		jumpMethod.invoke(user);
		
		Method sayMethod=userClass.getDeclaredMethod("say", String.class);
		//静态方法调用
		sayMethod.invoke(null, "Do you like van♂ 游戏？");
		
		System.out.println("----------------------接下来是构造器");
		Constructor<?>[] constructors=userClass.getConstructors();
		//获取所有的公有的构造器(无法获取父类的构造方法)
		for (Constructor c : constructors) {
			System.out.println(c.getModifiers()+" "+c.getName());
		}
		System.out.println("--------------------");
		//获取所有的构造器
		Constructor<?>[] declaredConstructors=userClass.getDeclaredConstructors();
		for (Constructor c : declaredConstructors) {
			System.out.println(c.getModifiers()+" "+c.getName());
		}
		
		//获取对应的Constructor对象获取实例
		Constructor<User> declaredConstructor=userClass.getDeclaredConstructor(String.class,String.class);
		//私有的构造器需要放开权限
		declaredConstructor.setAccessible(true);
		user=declaredConstructor.newInstance("van","♂");
		System.out.println("name:"+user.getName()+" "+"sex:"+user.sex);
		
	}

}

final class User extends Person1{
	private String name;
	public String sex;
	public static String address;

	public User() {

	}
	public User(String name) {
		this.name=name;
	}

	private User(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	
	private void jump() {
		System.out.println("jump...");
	}

	
	public String getName() {
		return name;
	}
	
	public static void say(String word) {
		System.out.println("say:"+word);
	}
}

class Person1{
	private String name;
	public String sex;
	
	public Person1() {
		
	}
	
	private void fun1() {
		
	}
	
	public void fun2() {
		
	}
}