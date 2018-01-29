package com.test.webdriver.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;

public class TestBaseApi2 {
	/*
	 * js的使用？
	 * Upload windows 本地的内容，如果遇见前台被限制成read-only 不能使用sendkeys传递path，可以使用js。怎么使用呢？
	 */
	
	private WebDriver driver;
	String url="http://localhost:8085/demo.html";
	
	public void startBrower() {
		System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void navigate() {
		driver.navigate().to(url);
	}
	
	public void close() {
		driver.close();
	}
	
	public void Alert() {
		WebElement element=driver.findElement(By.xpath("//div[@id='alert']/input"));
		element.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert =driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		alert.accept();//winodows窗口 确定按钮
		alert.dismiss(); //winodows窗口 取消按钮
	}
	
	public void testUpload() {
		WebElement element=driver.findElement(By.id("load"));
		element.sendKeys("D:\\demo\\curry1\\curry1.txt");
	}
	
	public void testJavaScript() throws InterruptedException {
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("alert('hello world')");//输入一段js 代码 
		Alert alert=driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		WebElement element=driver.findElement(By.id("user"));
		j.executeScript("arguments[0].value='123'", element);
		Thread.sleep(1000);
	
	}
	
	public void testMultiWindows() throws InterruptedException {
		WebElement element=driver.findElement(By.className("open"));
		element.click();
		Thread.sleep(1000);
		//把切换窗口的行为封装成一个方法，方便灵活使用。
		this.switchWindow(1);
		driver.close();
		Thread.sleep(1000);
	}
	
	private void switchWindow(int index) {
		//通过获得selenium 的方法获得新窗口的句柄
		Set<String> handles=driver.getWindowHandles();
		//因为getWindows 返回的是set 对象，而我们使用List来做操作，需要把set转换成set集合
		List<String> list=new ArrayList<String>(handles);
		driver.switchTo().window(list.get(index));
	}
	
	public void testAction() {
		
		WebElement element=driver.findElement(By.className("over"));
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		WebElement element2=driver.findElement(By.id("over"));
		String txt=element2.getText();
		System.out.println(txt);
	}
	
	public void testWait() {
		WebElement element=driver.findElement(By.className("wait"));
		element.click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		//匿名内部类
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				return d.findElement(By.className("red")).isDisplayed();
			}
		});
		WebElement element2=driver.findElement(By.className("red"));
		String txt=element2.getText();
		System.out.println(txt);
	}

	public void testIframe() {
		WebElement element=driver.findElement(By.xpath("//div[@id='input']"));
		driver.switchTo().frame(element);
		element.sendKeys("this is iframe");
		driver.switchTo().defaultContent();
	}
	public static void main(String[] args) throws InterruptedException {
		TestBaseApi2 tb2=new TestBaseApi2();
		tb2.startBrower();
		tb2.navigate();
		//tb2.Alert();
		//tb2.testJavaScript();
		//tb2.testMultiWindows();
		//tb2.testAction();
		tb2.testWait();
		tb2.testIframe();
		//tb2.close();
		
	}

}
