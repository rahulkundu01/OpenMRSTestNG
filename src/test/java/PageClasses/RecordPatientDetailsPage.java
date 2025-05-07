package PageClasses;

import org.openqa.selenium.By;

public class RecordPatientDetailsPage {
	
	
	
	
	public static By clickPatName()
	{		
	return	By.xpath("(//a[contains(text(),'Harry dsouza')])[1]");
	}
	
	public static By recordVitals()
	{
		return	By.xpath("//button[@class='-esm-patient-vitals__vitals-header__recordVitalsButton___kpFyI cds--btn cds--btn--sm cds--layout--size-sm cds--btn--ghost']");
	}
	
	public static By temprature()
	{
		return	By.xpath("//input[@name='Temperature']");
	}
	
	public static By systolic()
	{
		return	By.xpath("//input[@name='systolic']");
	}
	
	public static By diastolic()
	{
		return	By.xpath("//input[@name='diastolic']");
	}
	
	public static By heartRate()
	{
		return	By.xpath("//input[@name='Pulse']");
	}
	
	
	public static By submitDetails()
	{
		return	By.xpath("//button[@type='submit']");
	}
	public static By verifyVitals() {
		return By.xpath("//tbody[@aria-live='polite']/tr");
	}

}
