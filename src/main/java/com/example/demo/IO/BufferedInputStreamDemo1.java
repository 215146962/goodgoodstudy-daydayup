package com.example.demo.IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamDemo1 {

	public static void main(String[] args) {
		String s = File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s + "文件输入流.txt";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path1);
		} catch (FileNotFoundException e) {

		}
		// BufferedInputStream(InputStream in)默认构建一个8192大小的缓冲区
		// BufferedInputStream(InputStream in,int size)构建一个size大小的缓冲区(一般不用这个)
		BufferedInputStream bis = new BufferedInputStream(fis);

		byte[] bys = new byte[1024];
		int len = 0;
		try {
			while ((len = bis.read(bys)) != -1) {
				System.out.println(new String(bys, 0, len));
			}
		} catch (IOException e) {

		} finally {
			try {
				bis.close();
			} catch (IOException e) {

			}
		}
	}

}
