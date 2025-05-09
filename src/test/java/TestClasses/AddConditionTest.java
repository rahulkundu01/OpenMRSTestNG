package TestClasses;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import PageClasses.RecordConditionPage;
import Utilities.BaseClass;
import Utilities.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class AddConditionTest extends BaseClass{
	LoginTest obj4=new LoginTest();
	
	
	@Test(priority = 4, groups="sanity", retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void addCondition() throws InterruptedException {
		testConditions = reports.createTest("Add Conditions Test");
		logger.info("------------Verify the Add Condition Test ---------------");
		
		logger.info("Login menthod is called");
		loginNode = testConditions.createNode("Login method is called");
		obj4.executeLoginTest();
		loginNode.log(Status.INFO, "Calling Login Test");
		loginNode.log(Status.PASS, "Login successful");
		
		addExplicitWait(RecordConditionPage.clickOnPatName());
		driver.findElement(RecordConditionPage.clickOnPatName()).click();
		testConditions.log(Status.INFO, "Patient Name is clicked");
		logger.info("Clicked on paitent name");
		
		addExplicitWait(RecordConditionPage.clickOnRecordCondition());
		driver.findElement(RecordConditionPage.clickOnRecordCondition()).click();
		testConditions.log(Status.INFO, "Clicked on REcord condition");
		logger.info("Clicked on Record condition");
		
		addExplicitWait(RecordConditionPage.enterCondition());
		WebElement condition = driver.findElement(RecordConditionPage.enterCondition());
		condition.sendKeys("Paratyphoid Fever");
		/*Select s1 = new Select(condition);
		s1.selectByIndex(1);*/
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		    By.xpath("(//li[@class='-esm-patient-conditions__conditions-form__condition___4ZLvq'])[1]")  // use actual suggestion dropdown selector
		));
		for (WebElement suggestion : suggestions) {
		    if (suggestion.getText().equalsIgnoreCase("Paratyphoid Fever")) {
		        suggestion.click();
		        break;
		    }
		}
		
		testConditions.log(Status.INFO, "Added the condition type");
		logger.info("Added the condition type");
		
		addExplicitWait(RecordConditionPage.enterDate());
		driver.findElement(RecordConditionPage.enterDate()).sendKeys("05/05/2025");	
		testConditions.log(Status.INFO, "Entered the date");
		logger.info("Entered the date");
		
		addExplicitWait(RecordConditionPage.selectStatus());
		//driver.findElement(RecordConditionPage.selectStatus()).click();
		WebElement radio = driver.findElement(By.cssSelector("label[for='active']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", radio);
		testConditions.log(Status.INFO, "Select the status");
		logger.info("Select the status");
		
		addExplicitWait(RecordConditionPage.clickOnSaveBtn());
		driver.findElement(RecordConditionPage.clickOnSaveBtn()).click();
		testConditions.log(Status.INFO, "clicked on Save button");
		logger.info("Clicked on save button");
		
		addExplicitWait(RecordConditionPage.verifyCondition());
		List<WebElement> rows = driver.findElements(RecordConditionPage.verifyCondition());

	    for (WebElement row : rows) {
	        String firstCellText = row.findElement(By.tagName("td")).getText().trim();
	        if (firstCellText.equalsIgnoreCase("Paratyphoid Fever")){
	        	System.out.println("Test Passed: Condition added successfully");
	        	testConditions.log(Status.PASS, "Condition added successfully");
	        	logger.info("Test Case Passed: Condition added successfully");
	        }
	        else {
	        	System.out.println("Test Failed: Failed to add condition");
	        	testConditions.log(Status.FAIL, "Failed to add condition");
	        	logger.info("Test case failed: Unable to add condition");
	        }
	        
	    }
	    
		
	}

}
