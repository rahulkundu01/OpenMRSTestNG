package TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.RegisterPage;
import Utilities.BaseClass;
import Utilities.ListenerImplementation;


@Listeners(ListenerImplementation.class)

public class RegisterPatientTest extends BaseClass {
	
	LoginTest obj1=new LoginTest();
	RegisterPage rpObj= new RegisterPage();
	
	
	
	
	@DataProvider(name="MyDp1")
	public Object [][] method()
	{
		return new Object [][] {{"Harry","dsouza","32","Mumbai"}};
			
			//{"Henry","Williamson","45","Kolkata"}};
		
	}
	
	@Test(priority = 1, dataProvider="MyDp1",groups="sanity", retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void addPatient(String fn,String ln, String ag,String add) throws InterruptedException, IOException
	{   
		
		testRegister = reports.createTest("Verify Patient Registration");
		logger.info("***************TestCase Verify Register Patient starts*****************"); 
		//addImpicitWait();
		logger.info("Call the login method");
		loginNode = testRegister.createNode("Login Steps");
		obj1.executeLoginTest();
		loginNode.log(Status.INFO, "Calling Login Test");
		loginNode.log(Status.PASS, "Login successful");
	
		//
		
		addExplicitWait(RegisterPage.addPatientButton());
		driver.findElement(RegisterPage.addPatientButton()).click();
		logger.info("Clicked on Add patient menu button");
		testRegister.log(Status.INFO, "Clicked on Add patient menu button");
		
		addExplicitWait(RegisterPage.patientIdentityButton());
		driver.findElement(RegisterPage.patientIdentityButton()).click();
		logger.info("Clicked on Patient identity button");
		testRegister.log(Status.INFO, "Clicked on Patient identity button");
		
		addExplicitWait(RegisterPage.firstName());
		driver.findElement(RegisterPage.firstName()).sendKeys(fn);
		logger.info("Entered First name");
		testRegister.log(Status.INFO, "Entered First name");
		
		addExplicitWait(RegisterPage.lastName());
		driver.findElement(RegisterPage.lastName()).sendKeys(ln);
		logger.info("Entered Last name");
		testRegister.log(Status.INFO, "Entered Last name");
		
		addExplicitWait(RegisterPage.gender());
		scrollDown();
		driver.findElement(RegisterPage.gender()).click();
		logger.info("Select Gender radio button");
		testRegister.log(Status.INFO, "Select Gender radio button");
		
		addExplicitWait(RegisterPage.dobStataus());
		WebElement regElement = driver.findElement(RegisterPage.dobStataus());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", regElement);
		Thread.sleep(500);

		// Try regular click first
		try {
		    regElement.click();
		} catch (ElementClickInterceptedException e) {
		    // Fallback to JS click
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", regElement);
		}

		logger.info("Entered Date of Birth");
		testRegister.log(Status.INFO, "Entered Date of Birth");
		
		addExplicitWait(RegisterPage.age());
		driver.findElement(RegisterPage.age()).sendKeys(ag);
		logger.info("Entered Age");
		testRegister.log(Status.INFO, "Entered Age");
		
		addExplicitWait(RegisterPage.address());
		scrollDown();
		driver.findElement(RegisterPage.address()).sendKeys(add);
		logger.info("Entered Address");
		testRegister.log(Status.INFO, "Entered Address");
		
		addExplicitWait(RegisterPage.btnregPat());
		driver.findElement(RegisterPage.btnregPat()).click();
		logger.info("Clicked on register button");
		testRegister.log(Status.INFO, "Clicked on register button");
		
		Thread.sleep(3000);
		WebElement patId=driver.findElement(RegisterPage.validatePatID());
		
		if(patId.isDisplayed()==true)
		{
			System.out.println("Test Case Passed");
			//captureScreenShot(driver);
			testRegister.log(Status.PASS, "Test Case Passed: Registration Successful");
			logger.info("Test Case Passed: Registration Successful");
		}
		else
		{
			testRegister.log(Status.FAIL, "Test Case Failed: Registration Unsuccessful");
			logger.info("Test Case Failed: Registration Unsuccessful");
			throw new NullPointerException("Patient Registration Failed");
			
		}
		
		
		
		//driver.findElement(By.xpath(rpObj.closePg())).click();
		
		
		
		
		
	}
	
	
	
	

}
