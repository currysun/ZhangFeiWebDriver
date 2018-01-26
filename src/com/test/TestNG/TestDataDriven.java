package com.test.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDriven {
	/*
	 * TestNG 数据驱动
	 * 应用场景：10个用户需要登录测试。难道写10个方法来完成？
	 */
	@DataProvider(name="testData")
	public Object[][] DataProvider() {
		return new Object[][] {{1,2},{2,3},{3,4}};
	}
	
	@Test(dataProvider="testData")
	public void testDataDriven(int a,int b) {
		System.out.println("this is : "+(a+b));
	}
	
	//DataProvider 可以不定义name，直接调用其方法名。
	@DataProvider
	public Object[][] DataProvider2() {
		return new Object[][] {{1,2},{2,3},{3,4}};
	}
	
	@Test(dataProvider="DataProvider2")
	public void testDataDriven2(int a,int b) {
		System.out.println("this is : "+(a+b));
	}
}
