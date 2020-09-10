package com.example.demo.IOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCDemo {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-IOC.xml");
		User user=(User) ac.getBean("user");
		System.out.println(user);
	}

}
