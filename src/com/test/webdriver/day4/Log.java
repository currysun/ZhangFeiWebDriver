package com.test.webdriver.day4;

import org.apache.log4j.Logger;

public class Log {
		
	private Logger logger;
	
	public Log(Class<?> clazz) {
		logger=Logger.getLogger(clazz);
	}
	
	public Log(String s) {
		logger=Logger.getLogger(s);
	}
	
	public Log() {
		logger=Logger.getLogger("");
	}
}
