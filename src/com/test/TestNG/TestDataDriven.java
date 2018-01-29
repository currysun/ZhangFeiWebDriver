package com.test.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDriven {
	/*
	 * TestNG ��������
	 * Ӧ�ó�����10���û���Ҫ��¼���ԡ��ѵ�д10����������ɣ�
	 */
	@DataProvider(name="testData")
	public Object[][] DataProvider() {
		return new Object[][] {{1,2},{2,3},{3,4}};
	}
	
	@Test(dataProvider="testData")
	public void testDataDriven(int a,int b) {
		System.out.println("this is : "+(a+b));
	}
	
	//DataProvider ���Բ�����name��ֱ�ӵ����䷽������
	@DataProvider
	public Object[][] DataProvider2() {
		return new Object[][] {{1,2},{2,3},{3,4}};
	}
	
	@Test(dataProvider="DataProvider2")
	public void testDataDriven2(int a,int b) {
		System.out.println("this is : "+(a+b));
	}
}
