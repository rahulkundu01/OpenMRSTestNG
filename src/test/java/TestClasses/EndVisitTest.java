package TestClasses;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageClasses.EndVisitPage;
import PageClasses.RecordConditionPage;
import Utilities.BaseClass;

@Listeners(Utilities.ListenerImplementation.class)
public class EndVisitTest extends BaseClass {
LoginTest obj5=new LoginTest();
	
	
	@Test(priority = 5, groups="sanity", retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void endVisit() throws InterruptedException {
		test = reports.createTest("End Visit Steps");
		logger.info("---------------End Visit Cases --------------------");
		
		logger.info("Login method is called");
		loginNode = test.createNode("Login method is called");
		obj5.executeLoginTest();
		loginNode.log(Status.INFO, "Calling Login Test");
		loginNode.log(Status.PASS, "Login successful");
		
		addExplicitWait(EndVisitPage.clickOnPatientName());
		driver.findElement(EndVisitPage.clickOnPatientName()).click();
		test.log(Status.INFO, "Patient Name is clicked");
		logger.info("Patient Name is clicked");
		
		WebElement verifyActive = driver.findElement(EndVisitPage.verifyActiveTitle());
		Assert.assertTrue(verifyActive.isDisplayed(), "'Active' tag should be visible before ending visit.");
		logger.info("Verify that 'Active' tag should be visible before ending visit.");
		
		addExplicitWait(EndVisitPage.clickOnEndVisit());
		driver.findElement(EndVisitPage.clickOnEndVisit()).click();
		test.log(Status.INFO, "Clicked on End Visit Button");
		logger.info("Clicked on End Visit Button");
		
		addExplicitWait(EndVisitPage.clickPopupEndVisit());
		driver.findElement(EndVisitPage.clickPopupEndVisit()).click();
		test.log(Status.INFO, "Clicked on End Visit Button in Confirmation Popup");
		logger.info("Clicked on End Visit Button in Confirmation Popup");
		
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 boolean isTagGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(EndVisitPage.verifyActiveTitle()));
		 Assert.assertTrue(isTagGone, "'Active' tag should disappear after ending the visit.");
		 test.log(Status.PASS,"Test Passes: Active is not visible");
		 logger.info("Test Case Passed: Active is not visible");
		/* if(verifyActive.isDisplayed()) {
			System.out.println(" Test Failed: Active is still visible");
			test.log(Status.FAIL, "Test Failed: Active is still visible");
		}
		else {
			System.out.println("Test Passes: Active is not visible");
			test.log(Status.PASS,"Test Passes: Active is not visible");
		}*/
		
	}
	
}
