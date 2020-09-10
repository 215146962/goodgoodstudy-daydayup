package com.example.demo.IO.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReadDemo {
	public static void main(String[] args) {
		String s=File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s + "NIO输入流.txt";
		try(FileInputStream fileInputStream=new FileInputStream(path1)) {
			//针对本地磁盘进行操作
			FileChannel fileChannel=fileInputStream.getChannel();
			//读取数据，分配缓冲区大小
			ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
			/*byte[] bytes=new byte[1024];
			ByteBuffer byteBuffer=ByteBuffer.wrap(bytes);*/
			int rs=fileChannel.read(byteBuffer);
			System.out.println(new String(byteBuffer.array()));
			
			/*if (rs==-1) {
				
			}*/
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
