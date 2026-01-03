package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;


import com.automation.driver.DriverManager;
import com.automation.driver.Driverfactory;
import com.automation.utils.ConfigReader;

public class BaseTest {
	

public void setup(String browser) throws Exception {

WebDriver driver = Driverfactory.getInstance().CreateDriver(browser);
DriverManager.setDriver(driver);
ConfigReader reader = new ConfigReader("config.yaml");
String url=reader.getParentChildValue("qa", "baseUrl");
String time=reader.getValueByKey("timeOut");
driver.get(url);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(time)));
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(time)));
}	


public void tearDown() {
	DriverManager.getDriver().close();
	DriverManager.unload();
}
	
	
	
	
	
}
