package pageEvents;

import org.testng.Assert;

import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class HomePageEvents {
	ElementFetch ele = new ElementFetch();
	public void signInButton()
	{
		ele.getWebElement("XPATH", HomePageElements.StartHereButton).click();
		
		
	}
	
	public void AboutUs()
	{
		ele.getWebElement("XPATH", HomePageElements.AboutUsButton).click();
		Assert.assertEquals(ele.getWebElement("XPATH", HomePageElements.HomePageHeading).getText(), "About Us", "The page does not display the expected 'HOMEPAGE' text.");

	}
	
	public void FeatureTab()
	{
		ele.getWebElement("XPATH", HomePageElements.FeaturesTab).click();
	}
	
	public void ContactTab()
	{
		ele.getWebElement("XPATH", HomePageElements.ContactUs).click();
		Assert.assertEquals(ele.getWebElement("XPATH", HomePageElements.ContactUsHeading).getText(), "CRM Contacts", "The page does not display the expected Page");
	}
	
	public void pricingTab()
	{
		ele.getWebElement("XPATH", HomePageElements.Pricing).click();
		Assert.assertEquals(ele.getWebElement("XPATH", HomePageElements.pricingHeading).getText(), "CRM Software Pricing", "The page does not display the expected Page");
		
	}
	
	public void SignupTab()
	{
		ele.getWebElement("XPATH", HomePageElements.Signup).click();
		Assert.assertEquals(ele.getWebElement("XPATH", HomePageElements.SignupHeading).getText(), "Register", "The page does not display the expected Page");
		
	}
	
}
