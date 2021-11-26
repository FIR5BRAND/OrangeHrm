package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framewor.webdriver.WebDriverClass;

public class WebCommons {
	public WebDriver driver = WebDriverClass.getDriver();
	
	//Method to Click element
	public void Click(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		element.click();
	}
	
	//Method to enter text in textbox
	public void EnterInfo(WebElement element,String value) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		element.clear();
		element.sendKeys(value);
	}
	
	//Method to get title
	public String getTitle() {
		return driver.getTitle();
		
	}
	
	//Method to select option from dropdown
	public void selectDropdownOption(WebElement element,String value,String By) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		Select s = new Select(element);
		if(By.equals("VisibleText")) {
			s.selectByVisibleText(value);
		}else if(By.equals("value")) {
			s.selectByValue(value);
		}else if(By.equals("Index")) {
			s.selectByIndex(Integer.parseInt(value));
		}
	}
	
	//Method to select checkbox
	public void SelectCheckbox(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		if(!element.isSelected())
			element.click();
	}
	
	//Method to perform double click
	public void DoubleClick(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	//Method to perform right click
	public void RightClick(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	//Method to wait for next element
	public void ImplicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	//Method to Wait for locator
	public void WaitForElement(By locator,int Sec) {
		WebDriverWait wait = new WebDriverWait(driver, Sec);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	//Method to take screenshot
	public String takeScreenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot screen = (TakesScreenshot)driver; //to take screenshot
		File screenshotfile = screen.getScreenshotAs(OutputType.FILE); //to convert screenshot into file format
		String screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\"+screenshotname+".png"; //collect the folder path to store screenshot
		FileUtils.copyFile(screenshotfile, new File(screenshotpath));// copy screenshot file into folderpath		
		return screenshotpath;
	}
	
	//Method to generate random unique id
	public String getUniqueID() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMyyyyddhhmmss");		
		String uniqueRandomId = sdf.format(Calendar.getInstance().getTime());
		return uniqueRandomId;		
	}

}
