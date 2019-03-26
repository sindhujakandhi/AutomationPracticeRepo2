package com.qa.AutomationPractice.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/nareshguggilla/Downloads/chromedriver");
		driver =  new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().fullscreen();
		return driver;
		
		
	}
	
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream ip =  new FileInputStream("/Users/nareshguggilla/Documents/Selenium_Sessions/AutomationPractice/src/main/java/com/qa/AutomationPractice/configurations/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return prop;
		
	}

}
