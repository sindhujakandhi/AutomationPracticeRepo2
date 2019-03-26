package com.qa.AutomationPractice.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Automation.Constants.Constants;
import com.qa.AutomationPractice.BasePage.BasePage;
import com.qa.AutomationPractice.pages.HomePage;


public class HomePageTest {
	
	public BasePage basePage;
	public WebDriver driver;
	Properties prop;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver();
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		System.out.println("HomePageTitle is " + title);
		Assert.assertEquals(title,Constants.HOMEPAGE_TITLE);
		
	}
	@Test(priority = 2)
	public void verifySearchbarTest() {
		homePage.verifySearchbar("dresses");
		
	}
	@Test(priority = 3)
	public void verifyContactUsButtonTest() {
		homePage.verifyContactUsButton();
		System.out.println("ContactsUs page title is " + driver.getTitle());
		
		
	}
	@Test(priority = 4)
	public void verifySignUpButtonTest() {
		homePage.clickSignInButton();
		System.out.println("SignUp page title is " + driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		
	}

}
