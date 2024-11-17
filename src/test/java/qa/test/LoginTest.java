package qa.test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class LoginTest extends BaseTest {
  
  
  ElementFetch ele = new ElementFetch();
  HomePageEvents homePage = new HomePageEvents();
  LoginPageEvents loginPage = new LoginPageEvents();
  //@Test(dependsOnMethods = {"qa.test.HomeTest.HomePageTestCase"})
  @Test
  public void LoginHomePageTest() {
	 logger.info("Signin into LoginPage");
	 homePage.signInButton();
	 logger.info("verifying credentials");
	 loginPage.verifyingLoginPageIsLoaded();
	 logger.info("verifying login page");
	 loginPage.CredentialsSignIn();
	 logger.info("clicking on forgot password");
	 loginPage.ForgotPassword();
	 driver.navigate().back();
	 logger.info("clicking on signing through microsoft");
	 loginPage.LoginThroughMicrosoft();
	 driver.manage().window().minimize();
	 logger.info("sign in through Apple");
	 loginPage.LoginThroughApple();
	 
	 
	  
  }
}
