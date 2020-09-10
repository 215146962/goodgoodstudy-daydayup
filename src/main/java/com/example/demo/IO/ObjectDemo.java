package com.example.demo.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectDemo {

	public static void main(String[] args) {
		String s = File.separator;
		String path = "D:" + s + "输出流测试文件夹" + s + "user";
		//实现对象的序列化
		/*User user = new User("van♂", 18);
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
			os.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		//反序列化
		User user;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
			user = (User) is.readObject();
			System.out.println(user);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
