package com.example.demo.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author 21514
 * map的方法一般有
 * get(Object key)不存在的key就返回空
 * put(Object key ,Object value)
 * remove(Object key)如果key存在就删除
 * keySet()返回包含所有key的一个Set类型
 * entrySet()返回包含所有键值对的一个Set类型,键值对类型是Map.Entry<K,V>，也就是Set<Map.Entry<K,V>>
 * containsKey(key)判断是否包含指定的键名
 * containsValue(value)如果此映射将一个或多个键映射到指定值，则返回 true
 */

public class MapTest {

	public static void main(String[] args) {
		//LinkedHashMap
		Map linkHashmap=new LinkedHashMap();
		addData(linkHashmap);
		//通过EntrySet遍历map（也可以用迭代器遍历keySet集合）
		System.out.println("entrySet遍历---------------------------");
		Set set=linkHashmap.entrySet();
		for (Object object:set) {
			Map.Entry<Object, Object> entry=(Map.Entry<Object, Object>)object;
			System.out.println("("+entry.getKey()+","+entry.getValue()+")");
		}
		
		System.out.println("iterator遍历---------------------------");
		Set keySet=linkHashmap.keySet();
		Iterator iterator=keySet.iterator();
		while (iterator.hasNext()) {
			Object key=iterator.next();
			Object value=linkHashmap.get(key);
			System.out.println("("+key.toString()+","+value.toString()+")");
			
		}
		
		
		//红黑树(简单来说就是有顺序的map，可以玩一下)
		System.out.println("红黑树---------------------------");
		NavigableMap<String, Integer> navigatorTreeMap = new TreeMap<String, Integer>(); // SortedMap接收TreeMap的实例
		// 增加元素
		navigatorTreeMap.put("aa", 11);
		navigatorTreeMap.put("bb", 22);
		navigatorTreeMap.put("cc", 33);
		navigatorTreeMap.put("dd", 44);
		navigatorTreeMap.put("ee", 55);
		navigatorTreeMap.put("ff", 55);
		navigatorTreeMap.put("gg", 55);
 
		System.out.println(navigatorTreeMap.size());// 7个元素：7
		System.out.println(navigatorTreeMap.ceilingKey("cc"));// 返回大于等于cc的最小键：cc
		System.out.println(navigatorTreeMap.ceilingEntry("c"));//  返回一个键-值映射关系，它与大于等于cc的最小键关联：cc=33		
		System.out.println(navigatorTreeMap.descendingMap());// 返回逆序视图:{gg=55, ff=55, ee=55, dd=44, cc=33, bb=22, aa=11}
		System.out.println(navigatorTreeMap.firstKey());// 最小键:aa
		System.out.println(navigatorTreeMap.firstEntry());// 最小键对应的k-v键值对：aa=11
 
		System.out.println(navigatorTreeMap.floorEntry("c"));// 返回一个键-值映射关系，它与小于等于给定键的最大键关联:bb=22
		System.out.println(navigatorTreeMap.floorKey("cc"));//   返回小于等于cc的最大键:cc
		System.out.println(navigatorTreeMap.headMap("bb"));// 返回此映射的部分视图，其键值严格小于bb:{aa=11}
		System.out.println(navigatorTreeMap.headMap("bb", true));// 同上小于等于（true）:{aa=11, bb=22}
		System.out.println(navigatorTreeMap.higherEntry("c"));// 返回一个键-值映射关系，它与小于等于给定键的最大键关联:cc=33
		System.out.println(navigatorTreeMap.higherKey("cc"));//   返回小于等于cc的最大键:dd
		System.out.println(navigatorTreeMap.lastEntry());// 返回一个键-值映射关系，它与小于等于给定键的最大键关联:gg=55
		System.out.println(navigatorTreeMap.lastKey());//   返回小于等于cc的最大键:gg
		System.out.println(navigatorTreeMap.lowerEntry("c"));// 返回一个键-值映射关系，它与小于等于给定键的最大键关联:bb=22
		System.out.println(navigatorTreeMap.lowerKey("cc"));//    返回严格小于cc的最大键:bb
		System.out.println(navigatorTreeMap.pollFirstEntry());//  移除并返回与此映射中的最小键关联的键-值映射关系:aa=11
		System.out.println(navigatorTreeMap.pollLastEntry());//  移除并返回与此映射中的最大键关联的键-值映射关系:gg=55
		System.out.println(navigatorTreeMap.navigableKeySet());//   返回此映射中所包含键的
														// NavigableSet 视图。:[bb, cc, dd, ee, ff]
 
		System.out.println(navigatorTreeMap.subMap("aa", true, "dd", true));// 返回部分视图，true表示包括当前元素键值对:{bb=22, cc=33, dd=44}
		System.out.println(navigatorTreeMap.subMap("bb", "dd"));// 返回部分视图包括前面的元素，不包括后面的：{bb=22, cc=33}
		System.out.println(navigatorTreeMap.tailMap("cc"));// 返回元素大于cc的元素映射视图,包括cc：//{cc=33, dd=44, ee=55, ff=55}		
		System.out.println(navigatorTreeMap.tailMap("cc", false));// 返回元素大于等于cc的元素映射视图:{dd=44, ee=55, ff=55}
		System.out.println(navigatorTreeMap.descendingMap());// 返回此映射中所包含映射关系的逆序：{ff=55, ee=55, dd=44, cc=33, bb=22}视图。:
		System.out.println(navigatorTreeMap.descendingKeySet());// 返回此映射中所包含键的逆序
		
	}
	
	public static void addData(Map map) {
		for (int i = 1; i < 7; i++) {
			map.put("key"+i, "value"+i);
		}
	}

}
