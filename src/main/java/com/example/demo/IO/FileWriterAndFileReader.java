package com.example.demo.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterAndFileReader {

	public static void main(String[] args) {
		String s = File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s + "文件字符输入流.txt";
		String path2 = "D:" + s + "输出流测试文件夹" + s + "文件字符输出流.txt";
		try {
			FileReader fr=new FileReader(path1);
			FileWriter fw=new FileWriter(path2);
			int i=0;
			char[] by=new char[1024];
			while ((i=fr.read(by))!=-1) {
				fw.write(by,0,i);
				fw.flush();
			}
			fr.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
