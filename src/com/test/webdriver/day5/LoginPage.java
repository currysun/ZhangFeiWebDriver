package com.test.webdriver.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
	}


	//原始对象
	private By loginb=By.xpath("//span/button[@name='head_login']");
	private By usename=By.xpath("//div/input[@class='input']");
	private By pwd=By.xpath("//div/input[@type='password']");
	private By submit=By.xpath("//span/button[@type='submit']");
	
	//业务逻辑
	public void login(String username,String password) {
		this.getElement(loginb).click();
		this.getElement(usename).sendKeys(username);
		this.getElement(pwd).sendKeys(password);
		this.getElement(submit).click();
	}
	

}
