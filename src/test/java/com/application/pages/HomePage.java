package com.application.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.framewor.webdriver.WebDriverClass;
import com.framework.commons.WebCommons;

public class HomePage extends WebCommons {

	@FindBy(xpath = "//a[@id='welcome']")
	private WebElement welcomeLabel;

	By bywelcomeLabel = By.xpath("//a[@id='welcome']");

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	By bylogoutButton = By.xpath("//a[text()='Logout']");

	By byLoginPanelHeading = By.xpath("//div[@id='logInPanelHeading']");

	public void verifyWhetherAppLoginIsSuccessful() throws IOException {
		try {
			WaitForElement(bywelcomeLabel, 10);
		} catch (Exception e) {
			takeScreenshot(driver, "ApplicationLogin");
			Assert.fail("Application Login is Not Successful");
		}
	}

	public void clickOnLogoutButton() throws IOException {
		try {
			Click(welcomeLabel);
			WaitForElement(bylogoutButton, 5);
			Click(logoutButton);

		} catch (Exception e) {
			takeScreenshot(driver, "ApplicationLogout");
			Assert.fail("Application Logout is Not Successful");
		}
	}

	public void verifyApplicationLogout() throws IOException {
		try {
			WaitForElement(byLoginPanelHeading, 10);
		} catch (Exception e) {
			takeScreenshot(driver, "ApplicationLogout");
			Assert.fail("Application Logout is Not Successful");
		}
	}

	public static HomePage getHomePage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), HomePage.class);
	}

}
