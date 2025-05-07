package PageClasses;

import org.openqa.selenium.By;

import Utilities.BaseClass;

public class AddAppointmentPage extends BaseClass {
	
	public static By clickAppointmentMenu() {
		
		return By.xpath("//a[text()='Appointments']");
		
	}
	public static By clickCreateNewAppointment() {
		
		return By.xpath("//button[@aria-label='Search Patient Button']");
		
	}
	public static By searchAppointment() {
		
		return By.xpath("//input[@placeholder='Search for a patient by name or identifier number']");
		
	}
	public static By clickOnHome() {
		
		return By.xpath("//a[normalize-space()='Home']");
		
	}
	public static By clickOnStartVisit() {
		
		return By.xpath("(//button[@class='cds--btn cds--btn--primary' and @type ='button'])[1]");
		
	}
	public static By clickOnStartVisit_Profile() {
		return By.xpath("//button[@class='-esm-patient-chart__visit-header__startVisitButton___ZgOSy cds--btn cds--layout--size-lg cds--btn--primary']");
	}
	
	public static By enterDate() {
		
		return By.xpath("//input[@id='visitStartDateInput']");
		
	}
	public static By enterTime() {
		
		return By.xpath("//input[@id='visitStartTime']");
		
	}
	public static By selectVisitType() {
		
		return By.xpath("(//span[@class='cds--radio-button__appearance'])[3]");
		
	}
	public static By clickOnSubmit() {
		return By.xpath("//button[@type='submit']");
	}
	public static By verifyPatAdded() {
		return By.xpath("(//a[text()='Harry dsouza'])[1]");
	}
	
	
	
	
	

}
