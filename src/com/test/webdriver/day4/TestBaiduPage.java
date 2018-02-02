package com.test.webdriver.day4;

import java.io.Closeable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestBaiduPage {
	WebDriver driver;
	
	String url="https://www.baidu.com/";
	

	
	public void startDriver() {
		System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void navigate() {
		driver.navigate().to(url);
	}
	
	public void close() {
		driver.close();
	}
	
	@Test
	public void test() throws InterruptedException {		
		startDriver();
		navigate();
		BaiduPage bp=new BaiduPage(driver);
		bp.input();
		close();
	}
	
	
}
