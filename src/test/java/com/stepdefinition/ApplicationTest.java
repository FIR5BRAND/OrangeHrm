package com.stepdefinition;

import java.io.IOException;

import com.application.pages.HomePage;
import com.application.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationTest {
	
	@Given("Launch The Application")
	public void launch_the_application() throws IOException {
		LoginPage loginpage= LoginPage.getLoginPage();
		loginpage.launchApplication();
	}

	@Then("Verify The Title")
	public void verify_the_title() throws IOException {
		LoginPage loginpage= LoginPage.getLoginPage();
		loginpage.verifyApplicationTitle();	
	}

	@When("^I Enter (.*) And (.*)$")
	public void i_enter_Username_and_Password(String username,String password) throws IOException {
		LoginPage loginpage= LoginPage.getLoginPage();
		loginpage.loginIntoApplication(username, password);
	}
	
	@When("Click on Login Button")
	public void click_on_login_button() throws IOException {
		LoginPage loginpage= LoginPage.getLoginPage();
		loginpage.clickOnLoginButton();
	}

	@Then("Application Login Successful")
	public void application_login_successful() throws IOException {
		HomePage homepage = HomePage.getHomePage();
		homepage.verifyWhetherAppLoginIsSuccessful();	
	}

	@Then("Click on Logout Button")
	public void click_on_logout_button() throws IOException {
		HomePage homepage = HomePage.getHomePage();
		homepage.clickOnLogoutButton();
	}

	@Then("Application Logout Successful")
	public void application_logout_successful() throws IOException {
		HomePage homepage = HomePage.getHomePage();
		homepage.verifyApplicationLogout();
	}

}
