package com.example.demo.IO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class NIOSelectorServer {
	
	static Selector selector;//多路复用器
	
	public static void main(String[] args) {
		try {
			selector=Selector.open();//创建一个多路复用器
			ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();//创建ServerSocketChannel
			serverSocketChannel.configureBlocking(false);//多路复用器状态下，必须设置为非阻塞
			serverSocketChannel.socket().bind(new InetSocketAddress(8080));
			//把ServerSocketChannel注册到多路复用器上，并监听连接事件
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				selector.select();//阻塞，等待多路复用器上的某个事件就绪
				//selector.wakeup()唤醒处于select阻塞的线程
				Set<SelectionKey> selectionKeys=selector.selectedKeys();
				Iterator<SelectionKey> iterator=selectionKeys.iterator();
				while (iterator.hasNext()) {
					//拿到channel的key，使用迭代器移除，避免重复处理
					SelectionKey selectionKey=iterator.next();
					iterator.remove();
					
					if (selectionKey.isAcceptable()) {//连接事件
						handleAccept(selectionKey);
					}else if (selectionKey.isReadable()) {//读事件
						handleRead(selectionKey);
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void handleAccept(SelectionKey selectionKey) {
		ServerSocketChannel serverSocketChannel=(ServerSocketChannel) selectionKey.channel();
		try {
			SocketChannel socketChannel=serverSocketChannel.accept();//这里一定不会返回为空，一定存在客户端连接
			socketChannel.configureBlocking(false);//设置IO的非阻塞
			socketChannel.write(ByteBuffer.wrap("你好，啊van♂".getBytes()));
			//这里注册的是socketChannel的读事件
			socketChannel.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void handleRead(SelectionKey selectionKey) throws IOException {
		SocketChannel socketChannel=(SocketChannel) selectionKey.channel();
		ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
		socketChannel.read(byteBuffer);
		System.out.println("服务端接收到的信息是："+new String(byteBuffer.array()));
		
	}
	
}
