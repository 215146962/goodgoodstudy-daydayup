package com.example.demo.IO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOSelectorClient {

	static Selector selector;
	
	public static void main(String[] args) {
		try {
			selector=Selector.open();
			SocketChannel socketChannel=SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("localhost",8080));
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			while (true) {
				selector.select();
				Set<SelectionKey> selectionKeys=selector.selectedKeys();
				Iterator<SelectionKey> iterator=selectionKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = (SelectionKey) iterator.next();
					iterator.remove();
					if (selectionKey.isConnectable()) {
						handleConnect(selectionKey);
					}else if (selectionKey.isReadable()) {
						handleRead(selectionKey);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void handleConnect(SelectionKey selectionKey) throws IOException {
		SocketChannel socketChannel=(SocketChannel) selectionKey.channel();
		if (socketChannel.isConnectionPending()) {
			socketChannel.finishConnect();
		}
		socketChannel.configureBlocking(false);
		socketChannel.write(ByteBuffer.wrap("这里是客户端，发送请求".getBytes()));
		socketChannel.register(selector, SelectionKey.OP_READ);
		
	}
	
	private static void handleRead(SelectionKey selectionKey) throws IOException {
		SocketChannel socketChannel=(SocketChannel) selectionKey.channel();
		ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
		socketChannel.read(byteBuffer);
		System.out.println("客户端收到服务端的信息："+new String(byteBuffer.array()));
	}
}
