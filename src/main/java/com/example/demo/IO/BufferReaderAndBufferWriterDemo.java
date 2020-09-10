package com.example.demo.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferReaderAndBufferWriterDemo {

	public static void main(String[] args) throws IOException {
		// 高效字符输入输出流（就像高效字节输入流）
		String s = File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s + "高效字符输入流.txt";
		String path2 = "D:" + s + "输出流测试文件夹" + s + "高效字符输出流.txt";

		// 复杂写法（这种写法可以修改编码格式，简单写法不行）
//		File file1=new File(path1);
//		FileInputStream fis=new FileInputStream(file1);
//		InputStreamReader isr=new InputStreamReader(fis);	//字节流转字符流
//		BufferedReader br=new BufferedReader(isr);			//字符流转高效字符流

//		File file2=new File(path2);
//		FileOutputStream fos=new FileOutputStream(file2);
//		OutputStreamWriter osw=new OutputStreamWriter(fos);
//		BufferedWriter bw=new BufferedWriter(osw);

		// 简单写法，FileReader类是InputStreamReader的简便类，无法解决乱码问题
		// FileWriter同理
		BufferedReader br = new BufferedReader(new FileReader(path1));
		BufferedWriter bw = new BufferedWriter(new FileWriter(path2));
//		char[] chs = new char[1024];
//		int len = 0;
//		while ((len = br.read(chs)) != -1) {
//			String string = new String(chs, 0, len);
//			System.out.println(string);
//			bw.write(string);
//			bw.flush();
//		}

		// 按行读取
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();

	}

}
