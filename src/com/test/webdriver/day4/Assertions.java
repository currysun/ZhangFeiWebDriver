package com.test.webdriver.day4;

import org.testng.Assert;

public class Assertions {
	
	public static boolean flag=true;
	
	public static void verifyEquals(Object actual,Object expected) {
		try {
			
			Assert.assertEquals(actual, expected);
			
		} catch (Error e) {
			e.printStackTrace();
			flag=false;
		}
	}
	
	public static void verifyEquals(Object actual,Object expected,String message) {
		try {
			
			Assert.assertEquals(actual, expected,message);
			
		} catch (Error e) {
			e.printStackTrace();
			flag=false;
		}
	}
	
}
