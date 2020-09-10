package com.example.demo.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FileOutputStreamDemo1 {

	public static void main(String[] args) {
		// 创建文件字节输出流
		String s = File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s;
		String path2 = "文件输出流.txt";
		File file1 = new File(path1);
		// FileOutputStream(File file)构建一个写出文件的路径
		// 或者FileOutputStream(File file,boolean append)构建一个写出文件的路径，并是否通过在文件后面追加的方式写入
		// FileOutputStream(String name)直接提供文件路径，通过name生成一个File对象
		// FileOutputStream(String name,boolean append)同上
		file1.mkdirs();
		File file2 = new File(file1, path2);
		try {
			file2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream os = null;

		try {
			os = new FileOutputStream(file2, false);
			// 写出数据
			os.write(90);
			os.write(12);
			os.write(44);

			// 创建一个byte类数组
			byte[] by = { 11, 22, 33, 44, 55, 66 };
			os.write(by);
			os.write(by, 3, 3);// 输入数组从下标3开始后面的3个元素

			// 输出中文
			os.write("小霸王\n".getBytes());
			os.write("小霸王\n".getBytes("UTF-8"));//也可以设置编码格式GB2312或UTF-8,只能输出一种编码格式，否则会出现乱码

		} catch (IOException e) {
			try {
				if (os != null) {
					os.close();// 流关闭了，不能使用任何功能，只能重新创建
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
