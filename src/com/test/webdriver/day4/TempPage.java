package com.test.webdriver.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TempPage {

	WebDriver driver;
	
	private By close=By.id("close");
	
	public TempPage(WebDriver driver) {
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
	
	public void closeTemp() {
		this.getElement(close).click();
	}
	
}
