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
	//WebDriver 官方用法优化：原始对象和 业务逻辑的耦合关系的分离。
	//原始对象
	private By loginb=By.xpath("//span/button[@name='head_login']");
	private By usename=By.xpath("//div/input[@class='input']");
	private By pwd=By.xpath("//div/input[@class='input']");
	private By submit=By.xpath("//span/button[@type='submit']");
	
	public void startBrower() {
		System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void navigate() {
		driver.navigate().to(url);
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
	
	
	
	
	public void close() {
		driver.close();
	}
	

	
	@Test
	public void loginTest() {
		startBrower();
		navigate();
		LoginPage lp=new LoginPage(driver);
		lp.login("currysun", "sx65641633");
		TempPage tp=new TempPage(driver);
		tp.closeTemp();
		HomePage hp=new HomePage(driver);
		hp.enterMyLogPage();
		MylogPage mlp=new MylogPage(driver);
		mlp.writeLog("title curry");
		MyPage mp=new MyPage(driver);
		mp.switchmylog("title curry");
		mp.deletelog();
		close();
	}

}
