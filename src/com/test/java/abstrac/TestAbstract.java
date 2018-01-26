package com.test.java.abstrac;

public abstract class TestAbstract {

	/*
	 * 抽象类既可以有抽象方法，也可以有实体方法。
	 * 
	 */
	public abstract int getAdd();
	
	public int getAdd(int a,int b) {
		return a+b;
	}
}
