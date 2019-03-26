package com.qa.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.AutomationPractice.BasePage.BasePage;

public class SignInPage extends BasePage{
	
	@FindBy(xpath = "//button[@id = 'SubmitCreate']")
	WebElement createAccountButton;
	
	
	@FindBy(id= "email_create")
	WebElement emailField;

	public SignInPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage clickCreateButton(String email) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(emailField));
		emailField.sendKeys(email);
		
		createAccountButton.click();
		return new SignUpPage(driver);
	}

}
