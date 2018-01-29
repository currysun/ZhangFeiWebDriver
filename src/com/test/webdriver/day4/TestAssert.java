package com.test.webdriver.day4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssert {
	
	@Test
	public void testAssert() {
		System.out.println("assert test0.");
		Assert.assertEquals(1, 1);	
		Assertions.verifyEquals("curry", "curry");
		Assertions.verifyEquals("curry", "thomphson","verify two players failure. ");
		System.out.println("assert test1");
		Assert.assertTrue(Assertions.flag);
	}
}
