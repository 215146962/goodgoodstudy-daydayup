package com.example.demo.IO.NIO;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOWriteDemo {

	public static void main(String[] args) {
		String s=File.separator;
		String path1 = "D:" + s + "输出流测试文件夹" + s + "NIO输出流.txt";
		try(FileOutputStream fileOutputStream=new FileOutputStream(path1)) {
			FileChannel fileChannel=fileOutputStream.getChannel();
			ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
			byteBuffer.put("小霸王".getBytes());//往缓冲区写数据
			byteBuffer.flip();//把写模式转化为读模式
			fileChannel.write(byteBuffer);//往缓冲区读数据
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
