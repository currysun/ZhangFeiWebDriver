import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://172.20.30.246:8082/agilereporter");
		Thread.sleep(500);
		
		
		WebElement element=driver.findElement(By.id("loginForm:inputUsername"));
		element.sendKeys("admin");
	}

}
