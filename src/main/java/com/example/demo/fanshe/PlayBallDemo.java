package com.example.demo.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PlayBallDemo {

	public static void main(String[] args) {
		System.out.println("-------------通过传入的key获取ball对象");
		Ball ball = getInstanceByKey("football");
		ball.playBall();
		System.out.println("-------------通过反射动态获取对象");
		ball=getInstanceReflectByKey("FootBall");
		ball.playBall();
		ball=getInstanceReflectByKey("BasketBall");
		ball.playBall();
		
	}

	// 通过传入的key获取ball对象
	public static Ball getInstanceByKey(String key) {
		if ("basket".equals(key)) {
			return new BasketBall();
		}
		if ("football".equals(key)) {
			return new FootBall();
		}
		return null;
	}

	// 通过反射动态获取对象
	public static Ball getInstanceReflectByKey(String key) {
		String basePackage = "com.example.demo.fanshe";
		Ball ball = null;
		Class clazz=null;
		try {
			clazz = Class.forName(basePackage + "." + key);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Constructor constructor=null;
		try {
			constructor=clazz.getConstructor();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			ball=(Ball) constructor.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return ball;
		
	}

}
