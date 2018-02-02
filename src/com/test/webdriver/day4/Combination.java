package com.test.webdriver.day4;

import java.util.Arrays;

public class Combination {	
	

	private int[] arr = new int[] { 1, 2 };

	private int len = 5;

	public int[] mergeIntArray(int[] arr1, int[] arr2) {
		
		int[] arr = new int[arr1.length + arr2.length];
		for (int i = 0; i < arr1.length; i++) {
			arr[i] = arr1[i];
		}

		for (int i = 0; i < arr2.length; i++) {
			arr[arr1.length + i] = arr2[i];
		}
		return arr;
	}
	
	public void test(int[] cur) {
		if(cur.length==len) {
			System.out.println(Arrays.toString(cur));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			int[] temp=this.mergeIntArray(cur, new int[] {arr[i]});
			this.test(temp);
		}
	}

	public static void main(String[] args) {
		// 1,2  5Î»Êı
		Combination c=new Combination();
		
		int[] arr=new int[] {1,2};
		for (int i = 0; i < arr.length; i++) {
			c.test(new int[] {arr[i]});
		}
	//	c.test(new int[] {1});
		
	}

}
