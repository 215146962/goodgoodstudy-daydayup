package com.example.demo.IO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOSocketClient01 {

	public static void main(String[] args) {
		SocketChannel socketChannel;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);// 设置客户端为非阻塞false，默认是true
			// 在非阻塞模式下，这段代码不一定是等到连接建立之后再往下执行
			socketChannel.connect(new InetSocketAddress("localhost", 8080));
			if (socketChannel.isConnectionPending()) {
				socketChannel.finishConnect();
			}
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			byteBuffer.put("Do you like van♂游戏？".getBytes());
			byteBuffer.flip();// 将写模式转换为读模式
			socketChannel.write(byteBuffer);
			
			// 读取服务端返回的数据
			byteBuffer.clear();
			// 阻塞模式：这里会等待10秒钟，因为，服务端睡眠了10秒
			// 非阻塞模式：这里不阻塞
			int r = socketChannel.read(byteBuffer);
			if (r > 0) {
				System.out.println("收到服务端消息:" + new String(byteBuffer.array()));
			} else {
				System.out.println("服务端的数据未返回");
			}
			System.in.read();//在服务端不阻塞的情况下，执行该语句保证客户端的线程不结束
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
