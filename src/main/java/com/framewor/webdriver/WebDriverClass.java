package com.framewor.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.framework.utilities.ReadDataFromPropFile;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverClass {
	
	protected static WebDriver driver;
	
	//To Launch the Browser Session
	@Before
	public void setupBrowser() {	
		String browser=ReadDataFromPropFile.readProperties("Config.properties").getProperty("browser");  // To get browser details from property file
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}	
		setDriver(driver);
		driver.manage().window().maximize();	
	}
	
	
	//Method to Close Browser Session
	@After
	public void tearDown() {
		driver.quit();	
	}
	
	//Method to collect driver details from @Before method
	public void setDriver(WebDriver Driver) {
		driver=Driver;
	}
	
	//Method to share driver details with other classes
	public static WebDriver getDriver() {
		return driver;
	}	
	

}
