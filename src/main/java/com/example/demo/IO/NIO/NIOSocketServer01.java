package com.example.demo.IO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOSocketServer01 {

	public static void main(String[] args) {
		try {
			//可以支持两种模式，阻塞和非阻塞
			ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);//默认是true，设置为false就是非阻塞IO
			
			serverSocketChannel.socket().bind(new InetSocketAddress(8080));
			while (true) {
				//此处不再阻塞
				SocketChannel socketChannel= serverSocketChannel.accept();
				if(socketChannel!=null) {
					//如果代码进入这个位置，说明有连接过来
					ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
					socketChannel.read(byteBuffer);
					System.out.println(new String(byteBuffer.array()));
					//再把消息写回到客户端
					Thread.sleep(10000);
					byteBuffer.flip();
					socketChannel.write(byteBuffer);
				}else {
					Thread.sleep(3000);
					System.out.println("没有客户端连接过来");
				}
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
