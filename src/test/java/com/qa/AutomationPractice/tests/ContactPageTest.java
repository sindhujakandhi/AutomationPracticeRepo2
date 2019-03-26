package com.qa.AutomationPractice.tests;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Automation.Constants.Constants;
import com.qa.AutomationPractice.BasePage.BasePage;
import com.qa.AutomationPractice.pages.HomePage;
import com.qa.AutomationPractice.pages.ContactPage;

public class ContactPageTest {
	
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public HomePage homePage;
	public ContactPage contactPage;
	
	@BeforeMethod
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver();
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		contactPage = homePage.verifyContactUsButton();
		
	}
	
	@Test(priority = 1)
	public void verifyContactPageTitleTest() {
		String title = contactPage.verifyContactPageTitle();
		System.out.println("ContactUs page Title is " + title);
		Assert.assertEquals(title, Constants.CONTACTUSPAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyDefault_dropDownTest() {
		String selectedOption = contactPage.verifyDefault_dropDown();
		System.out.println("Default selected option is " + selectedOption);
		Assert.assertEquals(selectedOption, "-- Choose --");
		
	}
	
	@Test(priority = 3)
	public void verify_send_msg_detailsTest() {
		 String smsg = contactPage.verify_send_msg_details("Webmaster", "abc123@gmail.com", "123", "/Users/nareshguggilla/Downloads/poop.jpg", "Hello");
		 System.out.println("Success message is " +smsg);
		 Assert.assertEquals(smsg, Constants.SUCCESSMESSAGE);
	} 
	
	@Test(priority = 4)
	
	public void verifyHomePageButtonTest() {
		String title = contactPage.verifyHomePageButton();
		System.out.println("Returned to Home and title is " + title);
		Assert.assertEquals(title, Constants.HOMEPAGE_TITLE);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
 
}
