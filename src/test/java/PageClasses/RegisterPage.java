package PageClasses;

import org.openqa.selenium.By;

public class RegisterPage {
	
	 public static By addPatientButton() {
	        return By.xpath("//button[@class='cds--btn--icon-only -esm-patient-registration__add-patient-link__slotStyles___ejEWZ cds--header__action cds--btn cds--btn--primary']");
	    }
	
	//patient full name yes/no-->selected yes
	
	public static By patientIdentityButton()
	{
		
		return By.xpath("(//button[@type='button' and @aria-selected='true'])[1]");
		
	}
	
	//patient first name
	public static By firstName()
	{
		
		return By.xpath("//input[@id='givenName']");
		
	}
	//patient last name
	
	public static By lastName()
	{
		return By.xpath("//input[@id='familyName']");
		
		
	}
	//patient gender
	
	public static By gender()
	{
		
		return By.xpath("(//span[@class='cds--radio-button__appearance'])[1]");
		
	}
	//patient dob yes or no selected-->yes
	public static By dobStataus()
	{
		//String dobSt="(//button[@aria-selected='true'])[2]";
		return By.xpath("(//button[@aria-selected='false'])[2]");
	}
	//patient age
	public static By age()
	{
		String age="//input[@id='yearsEstimated']";
		return By.xpath(age);
		
	}
	//patient address first field
	public static By address()
	{
		String address="//input[@role='searchbox']";
		return By.xpath(address);
		
	}
	//click on register patient
	public static By btnregPat()
	{
		String btnregPat="//button[@type='submit']";
		return By.xpath(btnregPat);
		
	
	}
	//validate id is generated or not
	public static By validatePatID()
	{
		String valId="//*[text()='OpenMRS ID']";
		return By.xpath(valId);
		
	}
	
	/*public static String closePg()
	{
		String cPg="//button[@aria-label='Close']";
		return cPg;
		
	}*/
	
	
	
	
	

}
