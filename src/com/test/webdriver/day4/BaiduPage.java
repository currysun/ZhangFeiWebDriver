package com.test.webdriver.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BaiduPage {

	private WebDriver driver;
	
	
	public BaiduPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this); 
	}
	@FindBy(id="kw")
	public WebElement input;
	
	public void input() {
		input.sendKeys("Stephen curry");
	}
	


}
