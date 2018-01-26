package com.test.webdriver.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
/*
 * 1.Webdriver 输入框最重要的api sendkeys
 * 
 * sendKey后的值 就会变成属性？ 可以用getAttribute 来获取？
 */ 
 /**
  * 答：这是html input标签的特性，只针对input标签
 **/
 
 /* 
 * 2. Select 控件有单独的Select 类提供方法。
 * selectByIndex 是从0开始
 */

/*
 * 1.Input
 * 2.Link
 * 3.Select
 * 4.Radio box
 * 5.Check box
 * 6.button
 */
public class TestBaseApi {
	
	private WebDriver driver;
	
	String url="http://localhost:8085/demo.html";
	
	public void startDriver() {
		System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void navigate() {
		driver.navigate().to(url);
	}
	
	public void testInput(String value) {
		WebElement element=driver.findElement(By.id("user"));
		element.sendKeys(value);
		String v=element.getAttribute("value");
		System.out.println(v);
		//element.clear();
	}
	
	public void testLink() {
		WebElement element=driver.findElement(By.xpath("//div[@id='link']/a"));
		String href =element.getAttribute("href");
		System.out.println(href);
		String text=element.getText();
		System.out.println(text);
		element.click();
		driver.navigate().back();
	}
	
	public void testSelect() {
		WebElement element=driver.findElement(By.xpath("//div[@id='select']/select"));
		Select select=new Select(element);
		select.selectByValue("opel");
		select.selectByVisibleText("Saab");
		select.selectByIndex(0);
		String text=select.getFirstSelectedOption().getText();
	}
	
	public void testRaido(int index) {
		List<WebElement> elements=driver.findElements(By.xpath("//div[@id='radio']/input"));
		elements.get(index).click();
		boolean select=elements.get(index).isSelected();
		System.out.println(select);
		
	}
	
	public void testCheckBox(int index) {
		List<WebElement> elements=driver.findElements(By.xpath("//div[@id='checkbox']/input"));
		elements.get(index).click();
		boolean select=elements.get(index).isSelected();
		System.out.println(select);
		
	}
	
	public void testButton() {
		WebElement element=driver.findElement(By.xpath("//div[@id='button']/input"));
		//element.click();
		boolean button=element.isEnabled();
		System.out.println(button);
		
	}
	
	
	public void close() {
		driver.close();
		//driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TestBaseApi tb=new TestBaseApi();
		testInput(tb);	
		//testLink(tb);
		//testSelect(tb);		
		//testSelector(tb);
		//testCheckBox(tb);
		//testButton(tb);
	}
	public static void testButton(TestBaseApi tb) throws InterruptedException {
		tb.startDriver();
		tb.navigate();
		tb.testButton();
		Thread.sleep(1000);
		tb.close();
	}
	
	public static void testCheckBox(TestBaseApi tb) throws InterruptedException {
		tb.startDriver();
		tb.navigate();
		tb.testCheckBox(2);
		Thread.sleep(1000);
		tb.testCheckBox(3);
		tb.close();
	}

	public static void testSelector(TestBaseApi tb) throws InterruptedException {
		tb.startDriver();
		tb.navigate();
		tb.testRaido(1);
		Thread.sleep(1000);
		tb.close();
	}

	public static void testSelect(TestBaseApi tb) throws InterruptedException {
		tb.startDriver();
		tb.navigate();
		tb.testSelect();
		Thread.sleep(1000);
		tb.close();
	}

	public static void testLink(TestBaseApi tb) throws InterruptedException {
		tb.startDriver();
		tb.navigate();
		tb.testLink();;
		Thread.sleep(1000);
		tb.close();
	}

	public static void testInput(TestBaseApi tb) throws InterruptedException {
		tb.startDriver();
		tb.navigate();
		tb.testInput("hello world");
		Thread.sleep(1000);
		//tb.close();
	}
	
	

	

}
