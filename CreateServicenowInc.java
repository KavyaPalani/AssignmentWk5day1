package week5.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateServicenowInc extends BaseServicenowClass {
	@Test
	public void TC001_CreateIncident() throws IOException {
		
       //Click Create New
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
	
		//fill the mandatory fields
		driver.switchTo().frame(0);
	
		// Select a value for Caller and Enter value for short_description
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		// driver.findElement(By.id("sysverb_new")).click();

		// Window Handler
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandlesSet);
		String newWindow = list.get(1);
		driver.switchTo().window(newWindow);

		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(list.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.id("incident.short_description")).sendKeys("short description");
		driver.findElement(By.id("incident.description")).sendKeys("Button not working");
		WebElement category = driver.findElement(By.id("incident.category"));
		Select dd = new Select(category);
		dd.selectByIndex(1);
		WebElement dropdown = driver.findElement(By.name("incident.urgency"));
		Select dd2 = new Select(dropdown);
		dd2.selectByValue("3");
				
		WebElement dropdown2 = driver.findElement(By.name("incident.state"));
		Select dd3 = new Select(dropdown2);
		dd3.selectByVisibleText("New");
		// Read the incident number and save it a variable
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNumber);
		// Click on Submit button
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();

		// Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber, Keys.ENTER);
		// take snapshot of the created incident.
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/servicenow.jpg");
		FileUtils.copyFile(screenshot, image);

		// Verify the incident is created successful
		String incident = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		System.out.println(incident);
		
		if (incidentNumber.equals(incident))
			System.out.println("Incident created successfully");
		else
			System.out.println("Incident not created successfully");

	}

}