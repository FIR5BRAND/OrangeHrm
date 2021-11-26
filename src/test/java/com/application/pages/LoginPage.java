package com.application.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framewor.webdriver.WebDriverClass;
import com.framework.commons.WebCommons;
import com.framework.utilities.ReadDataFromPropFile;

public class LoginPage extends WebCommons{	
	
	@FindBy(id="logInPanelHeading")
	private WebElement LoginPanel ;
	
	@FindBy(xpath="//input[@name='txtUsername']")
	private WebElement usernameTextbox ;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	private WebElement passwordTextbox ;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton ;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPasswordLink ;
	
	By WelecomePageLocator = By.xpath("//a[@id='welcome']");
	
	
	public void launchApplication() throws IOException {
		try {
			driver.get(ReadDataFromPropFile.readProperties("Config.properties").getProperty("url"));
		}catch(Exception e) {
			takeScreenshot(driver, "ApplicationLaunch");
			Assert.fail("Error while Launching the Application");
		}
	}
	
	public void verifyApplicationTitle() throws IOException {
		if(getTitle().equals(ReadDataFromPropFile.readProperties("Config.properties").getProperty("PageTitle"))) {
		}else {
			takeScreenshot(driver, "ApplicationTitle");
			Assert.fail("Application Title Not Matched");
		}
	}
	
	public void loginIntoApplication(String username, String password) throws IOException {
		try {
			EnterInfo(usernameTextbox, username);
			EnterInfo(passwordTextbox, password);
		}catch(Exception e) {
			takeScreenshot(driver, "ApplicationLogin");
			Assert.fail("Error while updating credentials");
		}
	}
	
	public void clickOnLoginButton() throws IOException {
		try {
			Click(loginButton);			
		}catch(Exception e) {
			takeScreenshot(driver, "ApplicationLogin");
			Assert.fail("Error while Login Into the Application");
		}
	}
	
	public static LoginPage getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}

}
