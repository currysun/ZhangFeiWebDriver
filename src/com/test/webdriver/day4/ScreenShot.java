package com.test.webdriver.day4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	private WebDriver driver;
	
	public ScreenShot(WebDriver driver) {
		this.driver=driver;
	}
	
	private void taskScreenshot(String screenPath) {
		TakesScreenshot screen=(TakesScreenshot) driver;
		//这一步getScreenshotAs 方法返回的类型是OutputType 接口中的 FILE 对象。scrFile 还在内存中。
		File scrFile=screen.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void taskScreenshot() {
		String screenName=System.currentTimeMillis()+".jpg";
		File dir=new File("test-output/snapshot");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String screenPath= dir.getAbsolutePath()+File.separator+screenName;
		taskScreenshot(screenPath);
	}
	
}
