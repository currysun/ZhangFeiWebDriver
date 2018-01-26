package com.test.webdriver.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Chrome_AR {
		WebDriver driver;
		String url="http://172.20.30.246:8082/agilereporter/";
		
		
		public void startBrowser() {
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe"); 
			String chromebin="E:/Google/Chrome/Application/chrome.exe";
			ChromeOptions options = new ChromeOptions();
	        options.setBinary(chromebin);
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			ChromeDriver driver1 = new ChromeDriver(capabilities);
			driver=driver1;
			driver.manage().window().maximize();
		}
		
		public void navigate() {
			driver.navigate().to(url);
		}
		
		
		public void login(String un,String pw) {
			this.waitLogin();
			WebElement username=driver.findElement(By.id("loginForm:inputUsername"));
			WebElement password=driver.findElement(By.id("loginForm:inputPassword"));
			WebElement login=driver.findElement(By.id("loginForm:btnSignIn"));
			username.sendKeys(un);
			password.sendKeys(pw);
			login.click();	
			waitdashborad();
		}
		
		public void waitLogin() {
			WebDriverWait wait=new WebDriverWait(driver, 5);
			//匿名内部类
			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					return d.findElement(By.id("productNameBox")).isDisplayed();
				}
			});
		}
		
		public void waitdashborad() {
			WebDriverWait wait=new WebDriverWait(driver, 5);
			//匿名内部类
			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					return d.findElement(By.id("formHeader:errorBarBtn")).isDisplayed();
				}
			});
		}
		
		public void waitEntity() {
			WebDriverWait wait=new WebDriverWait(driver, 5);
			//匿名内部类
			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath("//div/div/div/div/div/div/label")).isDisplayed();
				}
			});
		}
		
		public void enterEntity() {		
			WebElement settings=driver.findElement(By.id("formHeader:giSetting"));
			WebElement entitysetup=driver.findElement(By.id("formHeader:imGroupMenuNative"));
			settings.click();
			entitysetup.click();
			waitEntity();
		}
		
		public void openEntity(String entity) throws Exception {
			WebElement group=driver.findElement(By.xpath("//label[text()='0001']/preceding-sibling::img[1]"));
			group.click();
			waitStatusDlg();
			Thread.sleep(1000);
		}
		
		public void switchassignTab() throws Exception {
			WebElement assign=driver.findElement(By.linkText("Assign Returns"));
			assign.click();
			waitStatusDlg();
		}
		
		public void waitStatusDlg() throws Exception
		{
			while (driver.findElement(By.xpath(".//*[starts-with(@id,'ajaxstatusDlg')]")).isDisplayed())
			{
				Thread.sleep(500);
			}
			while (driver.findElement(By.id("ajaxstatusDlg_modal")).isDisplayed())
			{
				Thread.sleep(500);
			}
			Thread.sleep(500);
		}
		
		public void closeBrowser() {
			driver.close();
		}
		
		
		@Test
		public void addAllReturn() throws Exception {
			try {
				String entity="0001";
				startBrowser();
				navigate();
				login("admin","password");	
				enterEntity();
				openEntity("0001");
				switchassignTab();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}


}
