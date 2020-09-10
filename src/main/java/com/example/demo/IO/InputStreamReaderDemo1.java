package com.example.demo.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo1 {

	public static void main(String[] args) throws IOException {
		// 字节输入流转字符输入流
		String s = File.separator;
		String path = "D:" + s + "输出流测试文件夹" + s + "字符输入流.txt";

		// 先准备一个字节流
		FileInputStream fis = new FileInputStream(path);
		// 准备一个输入的字符转换流
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

		// 读取单个字符
//		int ch = 0;
//		while ((ch = isr.read()) != -1) {
//			System.out.println(ch + ":" + (char) ch);
//		}

		// 一次整个字符数组
		char[] chs = new char[1024];
		int len = 0;
		while ((len = isr.read(chs)) != -1) {
			System.out.println(new String(chs, 0, len));
		}
		
		isr.close();
	}

}
