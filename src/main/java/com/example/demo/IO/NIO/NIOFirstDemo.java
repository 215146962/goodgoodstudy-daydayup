package com.example.demo.IO.NIO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFirstDemo {
	public static void main(String[] args) {
		//实现一个文件复制
		String s=File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s + "NIO输入流.txt";
		String path2 = "D:" + s + "输出流测试文件夹" + s + "NIO输出流.txt";
		try {
			FileInputStream fis=new FileInputStream(new File(path1));
			FileOutputStream fos=new FileOutputStream(new File(path2));
			//NIO channel -buffer
			FileChannel fin=fis.getChannel();
			FileChannel fout=fos.getChannel();
			//初始化一个缓冲区
			ByteBuffer buffer=ByteBuffer.allocate(1024);
			fin.read(buffer);//读取数据到缓冲区
			buffer.flip();//表示从读转化为写
			fout.write(buffer);
			buffer.clear();//重置缓冲区
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
