package com.example.demo.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MemoryDemo {

	static String str="Hello World";
	
	public static void main(String[] args) {
		//从内存中读取数据
		ByteArrayInputStream is=new ByteArrayInputStream(str.getBytes());
		//写出到内存中
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		int i=0;
		while ((i=is.read())!=-1) {
			char c=(char) i;
			os.write(Character.toUpperCase(c));
		}
		System.out.println(os.toString());
		//不需要调用close方法
	}

}
