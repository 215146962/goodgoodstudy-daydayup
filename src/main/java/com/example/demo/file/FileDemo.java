package com.example.demo.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/*关于路径的问题：
 * 1.使用“\”代表下级目录时，由于java中"\"表示转义符，所以用"\\"代表下级目录
 * 2.路径分割和操作系统有严格的区分
 * 	windows或者dos系统默认使用"\"来进行表示下级目录
 *  Unix和mac使用"/"来进行表示下级目录
 *
 */

public class FileDemo {

	public static void main(String[] args) throws IOException {
		String path1 = "C:\\Users\\21514\\Desktop\\";
		String path2 = "IO操作";
		// 根据路径得到一个确切的File对象
		File file = new File(path1);
		System.out.println("file:" + file);
		System.out.println("file.getName():" + file.getName());

		// 第二种创建File对象
		File file2 = new File(file, path2);
		System.out.println("file2:" + file2);

		// 第三种创建方式
		File file3 = new File(path1, path2);
		System.out.println("file3:" + file3);

		// 获取当前所使用的操作系统，然后确定写法（最笨的方法）
//		String s = System.getProperty("os.name");
//		System.out.println(s);
//		//判断使用的是哪种系统，确定路径的写法
//		if (s == "Windows 10") {
//			path1 = "C:\\Users\\21514\\Desktop\\";
//		} else if (s == "Mac OS X") {
//			path1 = "C:/Users/21514/Desktop/";
//		}

		// 直接使用File.separator获取分隔符
		String s = File.separator;// 根据系统环境自动识别下级目录分隔符
		String path3 = "C:" + s + "Users" + s + "21514" + s + "Desktop" + s;
		File file4 = new File(path3, path2);
		System.out.println("file4:" + file4);

		// 创建目录下文件，如果文件存在，就不再创建
		// System.out.println("创建文件：" + file.createNewFile());
		// 创建单级目录
		// System.out.println("创建单级目录：" + file.mkdir());
		// 创建多级目录
		// System.out.println("创建多级目录：" + file.mkdirs());
		// 下面是操作示范
		// 首先要先创建好文件夹，才能在文件夹中创建文件
		String path4 = "D:" + s + "File测试" + s;
		String filename = "学习.txt";
		File file5 = new File(path4);
		System.out.println("创建目录：" + file5.mkdirs());
		File file6 = new File(file5, filename);
		System.out.println("创建文件:" + file6.createNewFile());
		// 重命名,如果文件名已存在，则重命名失败.如果两个文件路径相同，则重命名；如果路径不同，则重命名并剪切
		// System.out.println("重命名：" + file6.renameTo(new File(file5, "测试.txt")));
		// 删除操作(删除目录只能删除为空的目录)
		// System.out.println("删除文件:" + file6.delete());

		/*
		 * String getAbsolutePath()获取文件的绝对路径 
		 * String getPath()获取相对路径 String
		 * getName()获取文件（目录）的名字 
		 * String length()获取文件字节大小 
		 * long lastModified()获取文件的最后一次修改时间
		 * 
		 */
		// 获取功能String[] list(),获取指定目录下面的所有文件和文件夹名字，返回一个数组
		System.out.println("目录下的所有文件-------------");
		for (String filename1 : file5.list()) {
			System.out.println(filename1);
		}
		// File[] listFiles获取指定目录下的所有文件和文件夹的File对象
		System.out.println("目录下的所有文件对象-------------");
		for (File f : file5.listFiles()) {
			System.out.println(f);
		}

	}

	// 封装删除目录及文件的步骤
	private static boolean deleteDir(File dir) {
		// isDirectory()判断是否为目录，isFiles()判断是否为文件,exists()判断文件是否存在
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

}
