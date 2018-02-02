package com.test.webdriver.day4;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPage {
	
WebDriver driver;
	
	private By mylog =By.xpath("//li/a[text()='我的日志']");
	private By title =By.xpath("//dl/dt/p/a");
	private By delete =By.xpath("//div/dl[1]/dt/a[2]");
	private By confirm=By.xpath("//span/button[text()='确 定']");
	private By tit=By.className("mb10");
	
	public MyPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getElement(By by) {
		if(this.waitDisplayed(by)) {
			return driver.findElement(by);
		}
		else {
			return driver.findElement(by);
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
	
	public void switchmylog(String expectResult) {
		this.getElement(mylog).click();
		String txtTitle=this.getElement(title).getText();
		assertEquals(txtTitle, expectResult,"Verify title value");
		ScreenShot ss=new ScreenShot(driver);
		ss.taskScreenshot();
		
	}
	
	public void deletelog() {
		boolean result=false;
		this.getElement(delete).click();
		this.getElement(confirm).click();
		WebElement title=this.getElement(tit);
		if(!title.isDisplayed()) {
			 result=true;
			 assertEquals(result, true);
		}
		else {
			result=false; 
			assertEquals(result, false);
		}
	}
}
