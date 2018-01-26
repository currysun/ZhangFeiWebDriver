package com.test.webdriver.day4;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TestLog {
	
	private Logger logger= Logger.getLogger(this.getClass());
	
	
	@Test
	public void testLog4j() {
		logger.info("this is test log4j's log !");
	}
	
	@Test
	public void testNgLog() {
		Reporter.log("this is TestNG log ");
	}
}
