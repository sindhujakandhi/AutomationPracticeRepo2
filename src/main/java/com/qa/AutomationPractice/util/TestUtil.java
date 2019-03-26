package com.qa.AutomationPractice.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.Automation.Constants.Constants;

public class TestUtil {

	public static void dropDownSelectByValue(WebElement element, String value) {

		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals(value)) {
				System.out.println("Req options is " + options.get(i).getText());
				options.get(i).click();
				break;
			}

		}

	}

	public static void dropDownSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void shortWait() {
		try {
			Thread.sleep(Constants.SHORT_WAIT);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void mediumWait() {
		try {
			Thread.sleep(Constants.MEDIUM_WAIT);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void longWait() {
		try {
			Thread.sleep(Constants.LONG_WAIT);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
//	public static Object[][] getTestContactsData(String sheetName) {
//		FileInputStream  file = null;
//		try {
//			 file =  new FileInputStream(Constants.CONTACTS_PATH);
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//		try {
//			book = WorkbookFactory.create(file);
//		} catch (InvalidFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		sheet = book.getSheet(sheetName);
//		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		for(int i=0; i<sheet.getLastRowNum();i++) {
//			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
//				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
//			}
//		}
//		return data;
//	}

}
