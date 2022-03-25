package week5.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateServicenowInc extends BaseServicenowClass  {
	@Test
	public  void TC002_UpdateIncident() {
		
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		//Search for the existing incident and click on the incident
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC000", Keys.ENTER);
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		
		//Update the incidents with Urgency as High and State as In Progress
		WebElement dropdown1 = driver.findElement(By.name("incident.urgency"));
		Select dd = new Select(dropdown1);
		dd.selectByValue("1");
				
		WebElement dropdown2 = driver.findElement(By.name("incident.state"));
		Select dd2 = new Select(dropdown2);
		dd2.selectByVisibleText("In Progress");
		//Click "Update" button.
		driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
		//Verify the priority and state 
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		WebElement urgency = driver.findElement(By.name("incident.urgency"));
		Select dd3 = new Select(urgency);
		System.out.println("The Urgency entered is " +dd3.getFirstSelectedOption().getText());	 
		WebElement state = driver.findElement(By.name("incident.state"));
		Select dd4 = new Select(state);
		System.out.println("The State entered is " +dd4.getFirstSelectedOption().getText());	
	}

}