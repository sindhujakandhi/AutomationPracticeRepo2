package com.qa.AutomationPractice.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.AutomationPractice.BasePage.BasePage;
import com.qa.AutomationPractice.pages.HomePage;
import com.qa.AutomationPractice.pages.SignInPage;
import com.qa.AutomationPractice.pages.SignUpPage;
import com.qa.AutomationPractice.types.Address;
import com.qa.AutomationPractice.types.UserInfo;


public class SignUpPageTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public HomePage homePage;
	public SignUpPage signUpPage;
	public SignInPage signInPage;
	
	@BeforeMethod
	 public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver();
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		signInPage = homePage.clickSignInButton();
		signUpPage = signInPage.clickCreateButton("a1bc12531@gmail.com");
		
		
	}
	
	@Test
	public void verifySignUpPageTest() {
		
		//Get data from excel
		
		//Create Users with excel data
		UserInfo[] users;
		
		//Create User object with data
		int[] dob = {11,7,1991};
		Address a = new Address("1234 Paradise St", "San Jose","CA", "95051", "USA");
		UserInfo u = new UserInfo("mrs", "sam", "k", "sam123", dob, "sam", "k", "emika", a, "additional", "123456", "123456" , a);
		
		// Call verify method with user data u
		signUpPage.verifySignUpForm(u);
		
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
	}
	
	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}
	
	

}
