package com.example.demo.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamDemo1 {

	public static void main(String[] args) {
		String s = File.separator;
		String path = "D:" + s + "输出流测试文件夹" + s + "文件输入流.txt";
		File file1 = new File(path);
		InputStream is = null;
		try {
			is = new FileInputStream(file1);
		} catch (FileNotFoundException e) {

		}
		int by = 0;
		// 遍历读取单个字节
		try {
			// by = is.read();
			// System.out.println("数字：" + by + " char:" + (char) by);
			while ((by = is.read()) != -1) {
				System.out.println("数字：" + by + " char:" + (char) by);
			}
		} catch (IOException e) {

		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 读取中文
		System.out.println("--------------------读取中文");
		try {
			is = new FileInputStream(file1);
		} catch (FileNotFoundException e) {

		}
		byte[] bys = new byte[1024];
		int len = 0;
		try {
			// 循环遍历
			while ((len = is.read(bys)) != -1) {// 返回值是当前数组的字节数量
				System.out.println("字节数量：" + len);
				String string = new String(bys, 0, len);
				System.out.println(string);
			}
		} catch (IOException e) {

		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
