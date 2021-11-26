package com.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = { "com.stepdefinition", "com.framewor.webdriver" }, plugin = { "pretty",
		"html:Report/AutomationReport.html" })

public class TestRunner {

}
