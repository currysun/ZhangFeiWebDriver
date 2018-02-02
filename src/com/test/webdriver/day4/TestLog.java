package com.test.webdriver.day4;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.This;


public class TestLog {
	
	private Logger logger= Logger.getLogger(this.getClass());
	
	private Log log=new Log(this.getClass());
	
	
	
	@Test
	public void testLog4j() {
		logger.info("this is test log4j's log !");
	}
	
	@Test
	public void testNgLog() {
		Reporter.log("this is TestNG log ");
	}
	
	@Test
	public void testDefinedLog() {
		log.info("this is defined log ! ");
	}
}
