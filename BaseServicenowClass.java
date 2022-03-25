package week5.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseServicenowClass {
	 public ChromeDriver driver;
	    
	 @BeforeMethod
		public void preCondition() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://dev114597.service-now.com");
			// Switch to Frame
			driver.switchTo().frame(0);
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("user_password")).sendKeys("vrPzn1pJCNS1");
			driver.findElement(By.id("sysverb_login")).click();
			// Search “incident “ Filter Navigator
			driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		}
	 
	 @AfterMethod
	 public void postCondition()
	 {
		 driver.quit();
	 }
	}
