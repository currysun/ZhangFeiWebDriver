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
	 * js��ʹ�ã�
	 * Upload windows ���ص����ݣ��������ǰ̨�����Ƴ�read-only ����ʹ��sendkeys����path������ʹ��js����ôʹ���أ�
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
		alert.accept();//winodows���� ȷ����ť
		alert.dismiss(); //winodows���� ȡ����ť
	}
	
	public void testUpload() {
		WebElement element=driver.findElement(By.id("load"));
		element.sendKeys("D:\\demo\\curry1\\curry1.txt");
	}
	
	public void testJavaScript() throws InterruptedException {
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("alert('hello world')");//����һ��js ���� 
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
		//���л����ڵ���Ϊ��װ��һ���������������ʹ�á�
		this.switchWindow(1);
		driver.close();
		Thread.sleep(1000);
	}
	
	private void switchWindow(int index) {
		//ͨ�����selenium �ķ�������´��ڵľ��
		Set<String> handles=driver.getWindowHandles();
		//��ΪgetWindows ���ص���set ���󣬶�����ʹ��List������������Ҫ��setת����set����
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
		//�����ڲ���
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
