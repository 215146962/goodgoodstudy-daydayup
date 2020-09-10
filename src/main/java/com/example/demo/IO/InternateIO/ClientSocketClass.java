package com.example.demo.IO.InternateIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocketClass {

	public static void main(String[] args) {
		final int DEFAULT_PORT = 8080;
		try {
			//建立一个连接
			Socket socket=new Socket("localhost",DEFAULT_PORT);
			BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("我是客户端发送的信息：Client-01\n");//这里记得加换行符，否则服务端认为还没有读取完毕
			bufferedWriter.flush();
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String serverStr=bufferedReader.readLine();
			System.out.println("收到服务端的消息："+serverStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
