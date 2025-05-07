package PageClasses;

import org.openqa.selenium.By;

public class LoginPage {
	
	public static By getUserName()
	{
		
	return	By.xpath("//input[@id='username']");
	}
	public static  By getContinueButton()
	{
		
		return By.xpath("//button[@class='-esm-login__login__continueButton___VnN+0 cds--btn cds--btn--primary']");
	}
	public static By getPassword()
	{
		
		return By.xpath("//input[@id='password']");
	}
	
	public static  By clickOnSumit()
	{
		
		return By.xpath("//button[@type='submit']");
	}
	public static By verifyLogin() {
		return By.xpath("//p[text()='Home']");
		
	}
	
	

}
