package com.example.demo.IO.InternateIO.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerSocketThread implements Runnable {

	Socket socket;
	
	public ServerSocketThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("客户端：" + socket.getPort() + "已连接");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String clientStr = bufferedReader.readLine();// 获得客户端输入的信息 一行
			System.out.println("收到客户端的请求信息："+clientStr);
			//输出
			BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("我已经收到了消息\n");//这里记得加换行符，否则客户端认为还没有读取完毕
			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
