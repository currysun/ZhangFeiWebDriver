package com.test.TestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestTestNG {
	
	@BeforeClass
	public void testBeforeClass() {
		System.out.println("Before class run");
	}
	
	@BeforeMethod
	public void testBeforeMethod() {
		System.out.println("Before method run");
	}
	
	@Test
	public void testMethod() {
		System.out.println("this is testng!");
	}
	
}
