package week5.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class DeleteServicenowInc extends BaseServicenowClass {
	@Test
    public void TC004_DeleteIncident() throws InterruptedException {
	driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
	
	//Search for the existing incident and click on the incident
	WebElement frame = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC000", Keys.ENTER);
	String incidentNo = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
	System.out.println("The incident number that gng to be deleted is" +incidentNo);
	driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
	
	//Delete the incident
	driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
	driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
	Thread.sleep(1500);
	//Verify the deleted incident
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNo, Keys.ENTER);
	//driver.findElement(By.id("incident_table_header_search_control")).sendKeys(incidentNo,Keys.ENTER);
	
	String text = driver.findElement(By.xpath("//tr[1]/td[text()='No records to display']")).getText();
	 System.out.println(text);
	if (text.equals("No records to display"))
		System.out.println("Incident Deleted Successfully");
	else
		System.out.println("Incident not Deleted");
}
}
