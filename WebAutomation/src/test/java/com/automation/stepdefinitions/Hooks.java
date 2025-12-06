package com.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.automation.base.BaseTest;
import com.automation.driver.DriverManager;
import com.automation.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
BaseTest base= new BaseTest();
ConfigReader reader = new ConfigReader("config.yaml");

@Before
public void before() throws Exception {
	String browser =reader.getParentChildValue("qa", "browser");
	base.setup(browser);
	driver= DriverManager.getDriver();
}
	

@After
public void after(Scenario scenario) {

	base.tearDown();
	
}

}
