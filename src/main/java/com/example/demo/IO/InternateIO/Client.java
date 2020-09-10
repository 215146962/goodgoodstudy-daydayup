package com.example.demo.IO.InternateIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	//客户端
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("localhost", 8080);
			//发送一个数据到服务端
			OutputStream outputStream=socket.getOutputStream();
			outputStream.write("Do you like van♂游戏？".getBytes("utf-8"));
			outputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
