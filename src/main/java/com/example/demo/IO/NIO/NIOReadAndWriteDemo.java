package com.example.demo.IO.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReadAndWriteDemo {

	public static void main(String[] args) {
		String s=File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s + "NIO输入流.txt";
		String path2 = "D:" + s + "输出流测试文件夹" + s + "NIO输出流.txt";
		
		try {
			FileInputStream fis=new FileInputStream(path1);
			FileOutputStream fos=new FileOutputStream(path2);
			FileChannel fin=fis.getChannel();
			FileChannel fout=fos.getChannel();
			
			ByteBuffer byteBuffer=ByteBuffer.allocate(3);
			while (true) {
				int r=fin.read(byteBuffer);
				if (r==-1) {
					break;
				}
				//每读到10个字节，写入缓冲区
				byteBuffer.flip();//把写模式转化为读模式
				fout.write(byteBuffer);
				byteBuffer.clear();//清空
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
