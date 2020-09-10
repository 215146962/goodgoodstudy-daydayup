package com.example.demo.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo1 {

	public static void main(String[] args) throws IOException {
		// 字节输出流转字符输出流
		String s = File.separator;
		String path = "D:" + s + "输出流测试文件夹" + s + "字符输出流.txt";
		File file = new File(path);
		FileOutputStream fos = new FileOutputStream(file);

		OutputStreamWriter osw = new OutputStreamWriter(fos);
		osw.write("Do you like van♂游戏\n");
		osw.write('a');
		osw.write(97);
		char[] chs = { 'a', 's', 's' };
		osw.write(chs);

		osw.flush();
		osw.close();
	}

}
