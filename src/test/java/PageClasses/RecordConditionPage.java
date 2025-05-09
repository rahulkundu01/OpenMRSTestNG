package PageClasses;

import org.openqa.selenium.By;

import Utilities.BaseClass;

public class RecordConditionPage extends BaseClass {
	
	public static By clickOnPatName()
	{		
	return	By.xpath("(//a[contains(text(),'Harry dsouza')])[1]");
	}
	
	
	public static By clickOnRecordCondition() {
		return By.xpath("//button[contains(normalize-space(),'Record conditions')]");
	}
	
	public static By enterCondition() {
		return By.xpath("//input[@placeholder='Search conditions']");
	}
	public static By enterDate() {
		return By.xpath("//input[@id='onsetDateInput']");
	}
	public static By selectStatus() {
		return By.xpath("(//label[@class='cds--radio-button__label'])[1]");
	}
	public static By clickOnSaveBtn() {
		return By.xpath("//button[@type='submit']");
	}
	
	public static By verifyCondition() {
		return By.xpath("(//tbody[@aria-live='polite']/tr)[1]");
	}

}
