package TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageClasses.RecordPatientDetailsPage;
import Utilities.BaseClass;
import Utilities.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class AddPatVitalsTest extends BaseClass

{
	LoginTest obj3=new LoginTest();
	
	@Test(priority = 3, groups = "sanity",retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void addPatVitals() throws InterruptedException{
		
		logger.info("---------- Add Patient Vitals ---------------------");
		testVitals = reports.createTest("Add Patient Vitals");
		
		logger.info("Login method is called");
		loginNode = testVitals.createNode("Login method is called");
	    obj3.executeLoginTest();
	    loginNode.log(Status.INFO, "Calling Login Test");
		loginNode.log(Status.PASS, "Login successful");
		
		
		addExplicitWait(RecordPatientDetailsPage.clickPatName());
		driver.findElement(RecordPatientDetailsPage.clickPatName()).click();
		logger.info("Clicked on Patient name");
		Thread.sleep(3000);
		addExplicitWait(RecordPatientDetailsPage.recordVitals());
		driver.findElement(RecordPatientDetailsPage.recordVitals()).click();
		testVitals.log(Status.INFO, "Clicked on Record Patient Details");
		logger.info("Clicked on record patient details");
		
		addExplicitWait(RecordPatientDetailsPage.temprature());
		driver.findElement(RecordPatientDetailsPage.temprature()).sendKeys("42");
		testVitals.log(Status.INFO, "Added Temperature");
		logger.info("Added Temperature");
		
		
		addExplicitWait(RecordPatientDetailsPage.systolic());
		driver.findElement(RecordPatientDetailsPage.systolic()).sendKeys("120");
		testVitals.log(Status.INFO, "Added systolic");
		logger.info("Added systolic");
		
		addExplicitWait(RecordPatientDetailsPage.diastolic());
		driver.findElement(RecordPatientDetailsPage.diastolic()).sendKeys("80");
		testVitals.log(Status.INFO, "Added diastolic");
		logger.info("Added diastolic");
		
		addExplicitWait(RecordPatientDetailsPage.heartRate());
		driver.findElement(RecordPatientDetailsPage.heartRate()).sendKeys("123");
		testVitals.log(Status.INFO, "Added Heart rate");
		logger.info("Added heart rate");
		
		addExplicitWait(RecordPatientDetailsPage.submitDetails());
		driver.findElement(RecordPatientDetailsPage.submitDetails()).click();
		testVitals.log(Status.INFO, "Clicked on Submit Details");
		logger.info("Clicked on submit details");
		
		addExplicitWait(RecordPatientDetailsPage.verifyVitals());
		WebElement tableRow = driver.findElement(RecordPatientDetailsPage.verifyVitals());
		String time = tableRow.findElement(By.xpath("./td[1]")).getText();
	    String pulse = tableRow.findElement(By.xpath("./td[2]")).getText();
	    String bp = tableRow.findElement(By.xpath("./td[3]")).getText();
	    String temp = tableRow.findElement(By.xpath("./td[4]")).getText();
	    System.out.println("Time: " + time);
	    System.out.println("Pulse: " + pulse);
	    System.out.println("BP: " + bp);
	    System.out.println("Temp: " + temp);
	    
	    Assert.assertEquals(bp, "120 / 80", "Blood pressure mismatch!");
	    testVitals.log(Status.PASS, "Successfully added the vitals");
	    logger.info("Test case passed: Vitals added successfully");
	    
	    
	}
	
	

}
