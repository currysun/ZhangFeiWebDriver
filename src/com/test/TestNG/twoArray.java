package com.test.TestNG;

public class twoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3,5,9,7,10};
		System.out.println(array);
		
		for (int  i= 0;  i< array.length; i++) {
			if(i==0) {
				System.out.print("["+array[i]+",");
			}
			else if(i>0&&i<array.length-1) {
				System.out.print(array[i]+",");
			}
			else {
				System.out.println(array[i]+"]");
			}
		
		}
		
		int[][] array2= {{1,2,3},{10,9,8},{100,200,300}};
		System.out.println(array2);
		
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				System.out.print(array2[i][j]);
			}
			
		}
	}

}
