package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 自动化测试常用的三大容器：
 * 
 * 1.数组
 * 
 * 2.list 有序可重复
 * 
 * 3.HashMap 无序
 * 
 */

public class CollectionDemo {
	
	public void testArray() 
	{
		String[] strings=new String[3];
		
	}
	
	public void testHashMap() {
		Map<String, String> map=new HashMap<String,String>();
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		
		System.out.println(map.get("b"));
		map.put("b", "4");
		System.out.println(map.get("b"));
		List<String> list=new ArrayList<String>(map.keySet());
		for(String s:list) {
			System.out.println(map.get(s));
		}
	}
	
	public void testArrayList() {
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		Integer[] integers=new Integer[list.size()];
		list.toArray(integers);
		System.out.println(integers[1]);
	}
	
	public static void main(String[] args) {
		CollectionDemo cd=new CollectionDemo();
		cd.testHashMap();
		//cd.testArrayList();
	}
	
}
