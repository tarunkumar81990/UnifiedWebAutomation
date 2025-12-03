package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.driver.DriverManager;
import com.automation.driver.Driverfactory;

public class BaseTest {

@Parameters("browser")	
@BeforeMethod
public void setup(@Optional("chrome") String browser) {

WebDriver driver = Driverfactory.getInstance().CreateDriver(browser);
DriverManager.setDriver(driver);
	
	
}	

@AfterMethod
public void tearDown() {
	DriverManager.getDriver().close();
	DriverManager.unload();
}
	
	
	
	
	
}
