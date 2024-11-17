package pageObjects;

public interface LoginPageElements {
	
	String LoginText = "//div[@class='ui fluid large blue submit button']";
	String EmailID = "//input[@placeholder='Email']";
	String Password = "//input[@placeholder='Password']";
	String SingInMicrosoft = "//*[name()='path' and contains(@fill,'#5e5e5e')]";
	String ForgotPassword = "//a[normalize-space()='Forgot your password?']";
	String SignInApple = "//button[@aria-label='Signin with apple ID']";
	
	

}
