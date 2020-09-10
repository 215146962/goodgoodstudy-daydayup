package com.example.demo.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest {

	public static void main(String[] args) throws IOException {

		// 通过缓冲流把图片复制并重命名新文件

		String s = File.separator;
		String source = "D:" + s + "输出流测试文件夹" + s + "darksouls.jpg";
		String dest = "D:" + s + "输出流测试文件夹" + s + "darksouls-副本.jpg";
		File file1 = new File(source);
		File file2 = new File(dest);
		FileInputStream fis = new FileInputStream(file1);
		FileOutputStream fos = new FileOutputStream(file2);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		// 单个读取
		Long start = System.currentTimeMillis();
		int i = 0;
		while ((i = bis.read()) != -1) {
			bos.write(i);
		}
		bis.close();
		bos.close();
		Long end = System.currentTimeMillis();
		System.out.println("单个读取时间（非缓冲）：" + (end - start));

		// 缓冲读取
		fis = new FileInputStream(file1);
		fos = new FileOutputStream(file2);
		bis = new BufferedInputStream(fis);
		bos = new BufferedOutputStream(fos);
		start = System.currentTimeMillis();
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys,0,len);
		}
		bis.close();
		bos.close();
		end = System.currentTimeMillis();
		System.out.println("加缓冲区读取时间：" + (end - start));
	}

}
