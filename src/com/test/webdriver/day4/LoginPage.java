package com.test.webdriver.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	//WebDriver �ٷ��÷��Ż���ԭʼ����� ҵ���߼�����Ϲ�ϵ�ķ��롣
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}


	//ԭʼ����
	private By loginb=By.xpath("//span/button[@name='head_login']");
	private By usename=By.xpath("//div/input[@class='input']");
	private By pwd=By.xpath("//div/input[@type='password']");
	private By submit=By.xpath("//span/button[@type='submit']");
	
	//ҵ���߼�
	public void login(String username,String password) {
		this.getElement(loginb).click();
		this.getElement(usename).sendKeys(username);;
		this.getElement(pwd).sendKeys(password);
		this.getElement(submit).click();
	}
	
	public boolean waitDisplayed(final By by) {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		boolean flag=true;
		try {
			 flag=wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					return d.findElement(by).isDisplayed();
				}
			});
			 
		} catch (Exception e) {
			flag=false;
		}
		return flag;		
	}

	
	public WebElement getElement(By by) {
		if(this.waitDisplayed(by)) {
			return driver.findElement(by);
		}
		else {
			return null;
		}
	}
}
