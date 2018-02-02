package com.test.webdriver.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MylogPage {

	WebDriver driver;
	
	private By writelog =By.xpath("//span/button[text()='–¥–¬»’÷æ']");
	private By input =By.id("atc_title");
	private By content =By.tagName("div");
	private By submit=By.xpath("//span/button[@name='Submit']");
	
	public MylogPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getElement(By by) {
		if(this.waitDisplayed(by)) {
			return driver.findElement(by);
		}
		else {
			return null;
		}
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
	
	public void writeLog(String title) {
		this.getElement(writelog).click();
		this.getElement(input).sendKeys(title);
		driver.switchTo().frame(0);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerHTML='123'", this.getElement(content));
		driver.switchTo().defaultContent();		
		this.getElement(submit).click();
	}
	

}
