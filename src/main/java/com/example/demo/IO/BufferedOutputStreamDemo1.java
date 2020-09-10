package com.example.demo.IO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo1 {

	public static void main(String[] args) throws IOException {
		// 高效字节流输出
		String s = File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s;
		String filename = "高效字节流输出.txt";
		File file1 = new File(path1);
		file1.mkdirs();
		File file2 = new File(file1, filename);
		file2.createNewFile();

		FileOutputStream fos = new FileOutputStream(file2);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String string = "我的剑就是你的剑";
		bos.write(string.getBytes());
		bos.flush();// 立刻把缓冲区的内容刷新到文件上
		bos.close();// 关闭这个流也可以把内容刷新到文件上

	}

}
