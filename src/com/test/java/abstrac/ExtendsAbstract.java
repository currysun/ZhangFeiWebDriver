package com.test.java.abstrac;

public class ExtendsAbstract extends TestAbstract {
/*
 * 1. ʵ���಻���г��󷽷���ֻ����ʵ�巽����
 * 
 * 2.����̳и��෽����ʵ�֡�
 */
	
	@Override
	public int getAdd() {
		int a=10;
		int b=1;
		return this.getAdd(a,b);
	}
	public static void main(String[] args) {
		ExtendsAbstract e=new ExtendsAbstract();
		System.out.println(e.getAdd());
	}
}
