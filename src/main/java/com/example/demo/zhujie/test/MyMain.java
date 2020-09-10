package com.example.demo.zhujie.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@InvokAnno(className = "com.example.demo.zhujie.test.Student2", methodName = "show")
public class MyMain {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 获取类对象
		Class<MyMain> clazz = MyMain.class;
		// 获取类对象中的注解
		InvokAnno an = clazz.getAnnotation(InvokAnno.class);
		/**
		 * 这里的an实际上是实现了InvokAnno接口 public class MyInvokAnno implements InvokAnno{ String
		 * className(){ return "com.example.demo.zhujie.test.Student1"; }
		 * 
		 * String methodName(){ return "show"; } }
		 */
		// 获取注解中对应的属性
		String className = an.className();
		String methodName = an.methodName();
		System.out.println(className);
		System.out.println(methodName);

		// 通过反射的方式实现接口的功能
		Class<?> clazz1 = Class.forName(className);
		Method method1 = clazz1.getDeclaredMethod(methodName);
		Object obj=clazz1.newInstance();
		method1.invoke(obj);	//执行对应的方法
	}
}
