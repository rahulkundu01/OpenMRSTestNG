package TestClasses;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageClasses.AddAppointmentPage;
import Utilities.BaseClass;

public class AddAppointmentTest extends BaseClass {
	LoginTest obj2=new LoginTest();
	@Test(priority = 2, groups="sanity", retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void addVisit() throws InterruptedException, AWTException {
	
		testAppointment = reports.createTest("Add Appointment Flow");
		logger.info("***************TestCase Verify  Add Appointment starts*****************");
		//loginNode = test.createNode("Login method is called");
		loginNode = testAppointment.createNode("Login Steps");
		logger.info("Login method is called");
		obj2.executeLoginTest();
		loginNode.log(Status.INFO, "Calling Login Test");
		loginNode.log(Status.PASS, "Login successful");
		
		addExplicitWait(AddAppointmentPage.clickAppointmentMenu());
		driver.findElement(AddAppointmentPage.clickAppointmentMenu()).click();
		testAppointment.log(Status.INFO, "Clicked on Appointment menu button");
		logger.info("Clicked on add appointment menu");
		
		addExplicitWait(AddAppointmentPage.clickCreateNewAppointment());
		driver.findElement(AddAppointmentPage.clickCreateNewAppointment()).click();
		testAppointment.log(Status.INFO, "Clicked on Create new appointment button");
		logger.info("Clicked on create new appointment");
		
		addExplicitWait(AddAppointmentPage.searchAppointment());
		driver.findElement(AddAppointmentPage.searchAppointment()).sendKeys("Harry dsouza");
		testAppointment.log(Status.INFO, "Search by the Patient name");
		logger.info("Search by the Patient name");
		
		addExplicitWait(AddAppointmentPage.clickOnStartVisit());
		driver.findElement(AddAppointmentPage.clickOnStartVisit()).click();
		testAppointment.log(Status.INFO, "Clicked on Start Visit Button");
		logger.info("Clicked on Start visit button");
		
		/*addExplicitWait(AddAppointmentPage.clickOnStartVisit_Profile());
		driver.findElement(AddAppointmentPage.clickOnStartVisit_Profile()).click();
		testAppointment.log(Status.INFO, "Clicked on Start Visit Button in Profile Page");*/
		
		addExplicitWait(AddAppointmentPage.enterDate());
		driver.findElement(AddAppointmentPage.enterDate()).sendKeys("04/05/2025");
		testAppointment.log(Status.INFO, "Entered the date");
		logger.info("Entered the date");
		
		addExplicitWait(AddAppointmentPage.enterTime());
		driver.findElement(AddAppointmentPage.enterTime()).sendKeys("2:45");
		testAppointment.log(Status.INFO, "Entered the time");
		logger.info("Entered time");
		
		addExplicitWait(AddAppointmentPage.selectVisitType());
		driver.findElement(AddAppointmentPage.selectVisitType()).click();
		testAppointment.log(Status.INFO, "Select the visit type");
		logger.info("Select the visit type");
		
		addExplicitWait(AddAppointmentPage.clickOnSubmit());
		driver.findElement(AddAppointmentPage.clickOnSubmit()).click();
		testAppointment.log(Status.INFO, "Clicked on Submit button");
		logger.info("Clicked on submit button");
		
		addExplicitWait(AddAppointmentPage.clickOnHome());
		driver.findElement(AddAppointmentPage.clickOnHome()).click();
		testAppointment.log(Status.INFO, "Clicked on Home");
		logger.info("Clicked on Home");

        System.out.println("Clicked on Home link.");

        // Optional wait before quitting
        Thread.sleep(3000);
        
		
		/*driver.navigate().refresh();
		System.out.println("Clicked in create new appointment");
		//addExplicitWait(AddAppointmentPage.clickOnHome());
		//driver.findElement(AddAppointmentPage.clickOnHome()).click();
		//addAppNode.log(Status.INFO, "Clicked on Home");
		Thread.sleep(2000);
		driver.get("https://o3.openmrs.org/openmrs/spa/home");*/
		/*addExplicitWait(AddAppointmentPage.clickOnHome());
		WebElement homeLink = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		// Use Actions to move and click
        Actions actions = new Actions(driver);
        actions.moveToElement(homeLink).click().perform();

        System.out.println("Clicked on Home link.");

        // Optional wait before quitting
        Thread.sleep(3000);*/
		
		
		addExplicitWait(AddAppointmentPage.verifyPatAdded());
		WebElement patAdd =	driver.findElement(AddAppointmentPage.verifyPatAdded());
		if(patAdd.isDisplayed()==true)
		{	testAppointment.log(Status.PASS, "Test Case Passed: Appointment created");
			System.out.println("Test case is successful");
			logger.info("Test Case Passes: Appointment Created");
		}
	
		else
		{ 
			testAppointment.log(Status.FAIL, "Test Case Failed: Appointment not created");
			logger.info("Test case failed: Appointment not created");
		 throw new NullPointerException("Patient Registation is failed");
		
		
		
	     }
		
		
		
	}

}
