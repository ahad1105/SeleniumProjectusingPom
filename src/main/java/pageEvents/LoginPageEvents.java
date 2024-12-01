package pageEvents;

import org.testng.Assert;

import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	
	ElementFetch ele = new ElementFetch();
	
	public void verifyingLoginPageIsLoaded()
	{
		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.LoginText).size()>0, "This is incorrect page directed to ");
		
	}
	
	public void CredentialsSignIn()
	{
		ele.getWebElement("XPATH", LoginPageElements.EmailID).sendKeys("ahad70429@gmail.com");
		ele.getWebElement("XPATH", LoginPageElements.Password).sendKeys("12345");
		
	}
	
	public void ForgotPassword()
	{
		ele.getWebElement("XPATH", LoginPageElements.ForgotPassword).click();
	}
	
	public void LoginThroughMicrosoft()
	{
		ele.getWebElement("XPATH", LoginPageElements.SingInMicrosoft).click();
	}
	
	public void LoginThroughApple()
	{
		ele.getWebElement("XPATH", LoginPageElements.SignInApple).click();
	}
	
	
	

}