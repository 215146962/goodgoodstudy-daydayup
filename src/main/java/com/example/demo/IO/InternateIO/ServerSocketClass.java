package com.example.demo.IO.InternateIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.demo.IO.InternateIO.thread.ServerSocketThread;

public class ServerSocketClass {
	// 启动一个服务端
	public static void main(String[] args) {
		final int DEFAULT_PORT = 8080;
		ServerSocket serverSocket = null;
		// 绑定一个监听端口
		try {
			serverSocket = new ServerSocket(DEFAULT_PORT);
			ExecutorService executorService=Executors.newFixedThreadPool(4);
			
			// 阻塞操作，等待客户端的链接
			while (true) {
				Socket socket = serverSocket.accept();
				executorService.submit(new ServerSocketThread(socket));//异步的处理方式
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
