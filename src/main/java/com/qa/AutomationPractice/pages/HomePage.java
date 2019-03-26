package com.qa.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.AutomationPractice.BasePage.BasePage;
import com.qa.AutomationPractice.util.TestUtil;

public class HomePage extends BasePage {
	
	
	@FindBy(linkText = "Sign in")
	WebElement signin_button;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement search_tab;
	
	@FindBy(xpath = "//button[@name = 'submit_search']")
	WebElement search_button;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUs_button;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public void verifySearchbar(String value) {
		search_tab.sendKeys(value);
		search_button.click();
		
	}
	
	public ContactPage verifyContactUsButton() {
		contactUs_button.click();
	
		return new ContactPage(driver);
		
		
	}
	public SignInPage clickSignInButton() {
		
		WebDriverWait wait =  new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(signin_button));
//		TestUtil.shortWait();
		signin_button.click();
		return new SignInPage(driver);
	}


}


