package com.qa.AutomationPractice.pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.AutomationPractice.BasePage.BasePage;
import com.qa.AutomationPractice.util.TestUtil;

public class ContactPage extends BasePage {
	
	@FindBy(id= "id_contact")
	WebElement subject_dropDown;
	
	@FindBy(id= "email")
	WebElement email;
	
	@FindBy(id= "id_order")
	WebElement order_ref;
	
	@FindBy(id= "fileUpload")
	WebElement attachFile;
	
	@FindBy(id="message")
	WebElement msg;
	
	@FindBy(id="submitMessage")
	WebElement send_button;
	
	@FindBy(xpath="//div[@id='center_column']/p")
	WebElement sucess_msg;
	

	@FindBy(xpath="//div[@class='breadcrumb clearfix']/a[@title = 'Return to Home']")
	WebElement homeButton;
	
	

	public ContactPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactPageTitle() {
		return driver.getTitle();
	}
	
	public String verifyDefault_dropDown()  {
		
		Select select = new Select(subject_dropDown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
		
	}
	
	public String verify_send_msg_details(String option, String emailVal, String ordernum , String path, String oredr_msg) {
		
		TestUtil.dropDownSelectByValue(subject_dropDown, option);
		
		WebDriverWait wait =  new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailVal);
		
		wait.until(ExpectedConditions.elementToBeClickable(order_ref));
		order_ref.sendKeys(ordernum);
		
//		wait.until(ExpectedConditions.elementToBeClickable(attachFile));
//		attachFile.sendKeys(path);
		
		wait.until(ExpectedConditions.elementToBeClickable(msg));
		msg.sendKeys(oredr_msg);
		
		wait.until(ExpectedConditions.elementToBeClickable(send_button));
		send_button.click();
		
		wait.until(ExpectedConditions.visibilityOf(sucess_msg));
		return sucess_msg.getText();
		
	}
	
	public String verifyHomePageButton() {
		

		WebDriverWait wait =  new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(homeButton));
		homeButton.click();
		TestUtil.shortWait();
		return driver.getTitle();
		
		
	}

}

