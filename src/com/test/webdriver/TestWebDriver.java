package com.test.webdriver;

import java.io.File;
import java.io.IOException;

import org.omg.CORBA.CharHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class TestWebDriver {
	
	public WebDriver driver;
	
	
	public void startBrowser() {
		System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
	public void startFirefoxWithAddon() {
		File file=new File("files/firebug-1.8.4.xpi");
		FirefoxProfile profile=new FirefoxProfile();
		try {
			profile.addExtension(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//driver =new FirefoxDriver(profile);
	}
	
	public void firefoxStartWithProfile() {
		ProfilesIni profiles=new ProfilesIni();
		FirefoxProfile profile=profiles.getProfile("default");
		FirefoxOptions option=new FirefoxOptions();
		//driver =new FirefoxDriver(profile);
		//
		//profile.addExtension("firebug");
	}
	
	public void maxBrowser() {
		driver.manage().window().maximize();
	}
	
	public void startChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	public void startChromeBrowserWithAddon() {
		System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		File file=new File("files/Video-Sorter-for-YouTube_v1.1.2.crx");
		options.addExtensions(file);
		driver=new ChromeDriver(options);
	}
	
	
	public static void main(String[] args) {
		TestWebDriver test=new TestWebDriver();
		//test.startBrowser();
		//test.startFirefoxWithAddon();
		//test.maxBrowser();
		//test.startFirefoxWithAddon();
		//test.closeBrowser();
		
		
		//chrome
		test.startChromeBrowser();
		test.maxBrowser();
		test.startChromeBrowserWithAddon();
		//test.closeBrowser();
	}

}
