package TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.LoginPage;
import Utilities.BaseClass;
import Utilities.ExtentManager;
import Utilities.FetchDataFromProperty;

@Listeners(Utilities.ListenerImplementation.class)
public class LoginTest extends BaseClass {
	
	LoginPage obj=new LoginPage();
	
	
	
	@Test(priority=0,groups="sanity", retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void executeLoginTest() throws InterruptedException
	{
		
		testLogin = reports.createTest("Verify Valid Login");
		logger.info("***************TestCase Verify Login starts*****************"); 
		addImpicitWait();
		try {
			driver.findElement(LoginPage.getUserName()).sendKeys(FetchDataFromProperty.readDataFromProperty().getProperty("email"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		testLogin.log(Status.INFO, "Username is entered");
		logger.info("User enters username");
		driver.findElement(LoginPage.getContinueButton()).click();	
		testLogin.log(Status.INFO, "User clicks on Continue button");
		logger.info("User clicks on continue button");
		try {
			driver.findElement(LoginPage.getPassword()).sendKeys(FetchDataFromProperty.readDataFromProperty().getProperty("password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testLogin.log(Status.INFO, "Username is Password");
		logger.info("User enters password");
		driver.findElement(LoginPage.clickOnSumit()).click();
		testLogin.log(Status.INFO, "Username click on Submit button");
		logger.info("User clicks on Submit button");
		WebElement homeText=driver.findElement(LoginPage.verifyLogin());
		if(homeText.isDisplayed()) {
			testLogin.log(Status.PASS, "Login Successful");
			logger.info("Login Successful");
		}
		else {
			testLogin.log(Status.FAIL, "Login Unuccessful");
			logger.info("Login unuccessful");
			throw new NullPointerException("Patient Login Failed");
		}
		
		
		
	}
	
	/*@AfterTest
	public void closeBrowser() throws InterruptedException {
		teardown();
	}*/
	
	
	
	
		
	
	
	
	
	
	

}
