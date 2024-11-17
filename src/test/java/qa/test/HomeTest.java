package qa.test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class HomeTest extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	
	 @Test
	  public void HomePageTestCase() {
		 logger.info("Clicking on about us button");
		 homePage.AboutUs();
		 logger.info("Navigated to about us section");
		 driver.navigate().back();
		 logger.info("Clicking on about feature tab");
		 homePage.FeatureTab();
		 logger.info("Clicking on contact us option");
		 homePage.ContactTab();
		 driver.navigate().back();
	 }
	 
	 @Test
		public void HomePageTestCase2()
		{
		 logger.info("Clicking on pricing tab");
		 homePage.pricingTab();
		 logger.info("nvigated to pricing tab section");
		 driver.navigate().back();
		 logger.info("Clicking on signup tab");
		 homePage.SignupTab();
		 logger.info("navigated to signup tab");
		 driver.navigate().back();
	  
	  }
	 
	 
}
