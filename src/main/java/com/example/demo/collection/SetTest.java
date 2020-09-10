package com.example.demo.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("iterator遍历hashset--------------");
		Set set = new HashSet();
		addData(set);
		// iterator遍历输出
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			String str = (String) iterator.next();
			System.out.print(str + " ");
		}
		System.out.println();

		System.out.println("TreeSet-------------------------");
		// 红黑树，默认对元素进行自然排序
		TreeSet treeSet = new TreeSet(new MyComparator());// 把自定义的比较器放进TreeSet中
		//addData(treeSet);//这里调用的是父类的add方法，TreeSet不会进行排序，想要进行排序就要调用TreeSet的add方法
		//添加数据
		treeSet.add("acb");
		treeSet.add("cab");
		treeSet.add("bbc");
		treeSet.add("bca");
		for (Object obj : treeSet) {
			System.out.println((String) obj);
		}
	}

	public static void addData(Set set) {
		set.add("小志龙");
		set.add("小霸王");
		set.add("小汉东");
		set.add("小懋坤");
	}
}

//给TreeSet容器设置一个自定义比较器
class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String str1 = (String) o1;
		String str2 = (String) o2;
		// 按字符串从小到大顺序排序
		if (str1.compareTo(str2) == 1) {
			return -1;
		} else {
			return 1;
		}
	}

}