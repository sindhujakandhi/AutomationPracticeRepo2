package com.qa.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.AutomationPractice.BasePage.BasePage;
import com.qa.AutomationPractice.types.UserInfo;

public class SignUpPage extends BasePage {

	

	@FindBy(id = "id_gender2")
	WebElement female;

	@FindBy(id = "id_gender1")
	WebElement male;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "days")
	WebElement daysdropDown;

	@FindBy(id = "months")
	WebElement monthsDropDown;

	@FindBy(id = "years")
	WebElement yearsDropDown;

	@FindBy(id = "firstname")
	WebElement aFirsName;

	@FindBy(id = "company")
	WebElement aCompany;

	@FindBy(id = "lastname")
	WebElement aLastName;
	
	@FindBy(id = "address1")
	WebElement add1;
	
	
	@FindBy(id = "city")
	WebElement acity;
	
	@FindBy(id = "id_state")
	WebElement state;
	
	
	@FindBy(id = "postcode")
	WebElement zipcode;
	
	
	@FindBy(id = "id_country")
	WebElement country;
	
	@FindBy(id = "other")
	WebElement otherMsg;
	
	
	
	@FindBy(id = "phone")
	WebElement hPhn;
	
	
	@FindBy(id = "phone_mobile")
	WebElement mPhn;
	
	@FindBy(id = "alias")
	WebElement aliasAdd;
	
	@FindBy(id = "submitAccount")
	WebElement registerButton;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	

	public void verifySignUpForm(UserInfo u) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		if (u.title.equals("mrs")) {
			wait.until(ExpectedConditions.elementToBeClickable(female));
			female.click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(male));
			male.click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(u.firstName);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(u.lastName);

		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(u.password);
		
//		wait.until(ExpectedConditions.elementToBeClickable(daysdropDown));
		Select select = new Select(daysdropDown);
		select.selectByIndex(u.dob[1]);
		
//		wait.until(ExpectedConditions.elementToBeClickable(monthsDropDown));
		select = new Select(monthsDropDown);
		select.selectByIndex(u.dob[0]);
		
//		wait.until(yearsDropDown);
		select = new Select(yearsDropDown);
		select.selectByValue(""+u.dob[2]);
		
		aFirsName.sendKeys(u.aFirstName);
		aLastName.sendKeys(u.aLastName);
		aCompany.sendKeys(u.company);
		add1.sendKeys(u.addr.street);
		acity.sendKeys(u.addr.city);
		state.sendKeys(u.addr.state);
		zipcode.sendKeys(u.addr.Zipcode);
		country.sendKeys(u.addr.country);
		otherMsg.sendKeys(u.additionalInfo);
		hPhn.sendKeys(u.homeph);
		mPhn.sendKeys(u.mphn);
		aliasAdd.sendKeys(u.addr.city);
		//registerButton.click();
	}

}
