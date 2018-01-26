package com.test.java.abstrac;

public class ExtendsAbstract extends TestAbstract {
/*
 * 1. 实体类不能有抽象方法，只能有实体方法。
 * 
 * 2.子类继承父类方法的实现。
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
