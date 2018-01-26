package com.test.webdriver.day4;

import static org.testng.Assert.assertEquals;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentDemo1 {
	private WebDriver driver;
	String url="http://localhost/phpwind/index.php";
	
	public void startBrower() {
		System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void navigate() {
		driver.navigate().to(url);
	}
	
	public void login(String username,String password) {
		WebElement loginbutton=driver.findElement(By.xpath("//span/button[@name='head_login']"));
		loginbutton.click();
		WebElement inputusrname=driver.findElement(By.xpath("//div/input[@class='input']"));
		WebElement inputpwd=driver.findElement(By.xpath("//div/input[@type='password']"));
		WebElement loginsubmit=driver.findElement(By.xpath("//span/button[@type='submit']"));
		inputusrname.sendKeys(username);
		inputpwd.sendKeys(password);
		loginsubmit.click();
		
	}
	
	public void tempclose() {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("close")).isDisplayed();
			}
		});
		WebElement close=driver.findElement(By.id("close"));
		close.click();
	}
	
	public void enterLogPage() {
		WebElement tunnel=driver.findElement(By.id("td_mymenu"));
		Actions action=new Actions(driver);
		action.moveToElement(tunnel).perform();
		WebElement mylog=driver.findElement(By.xpath("//li/a/img[@alt='日志']"));
		mylog.click();
	}
	
	public void writeLog(String title) {
		WebElement writenew=driver.findElement(By.xpath("//span/button[text()='写新日志']"));
		writenew.click();
		WebElement inputTitle=driver.findElement(By.id("atc_title"));
		inputTitle.sendKeys(title);
		
		//driver.navigate().refresh();
		driver.switchTo().frame(0);
		WebElement content=driver.findElement(By.tagName("div"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerHTML='123'", content);
		driver.switchTo().defaultContent();		
		WebElement submit =driver.findElement(By.xpath("//span/button[@name='Submit']"));
		submit.click();
	}
	
	public void switchmylog(String expectResult) {
		WebElement mylog=driver.findElement(By.xpath("//li/a[text()='我的日志']"));
		mylog.click();
		WebElement title=driver.findElement(By.xpath("//dl/dt/p/a"));
		String txtTitle=title.getText();
		assertEquals(txtTitle, expectResult,"Verify title value");
		ScreenShot ss=new ScreenShot(driver);
		ss.taskScreenshot();
		
	}
	
	public void deletelog() {
		boolean result=false;
		WebElement delete =driver.findElement(By.xpath("//div/dl[1]/dt/a[2]"));
		delete.click();
		WebElement confirm=driver.findElement(By.xpath("//span/button[text()='确 定']"));
		confirm.click();
		WebElement title=driver.findElement(By.className("mb10"));
		if(!title.isDisplayed()) {
			 result=true;
			 assertEquals(result, true);
		}
		else {
			result=false; 
			assertEquals(result, false);
		}
	}
	
	public void close() {
		driver.close();
	}
	
	@Test
	public void loginTest() {
		startBrower();
		navigate();
		login("currysun","sx65641633");
		tempclose();
		enterLogPage();
		writeLog("title curry");
		switchmylog("title curry");
		deletelog();
		close();
	}

}
