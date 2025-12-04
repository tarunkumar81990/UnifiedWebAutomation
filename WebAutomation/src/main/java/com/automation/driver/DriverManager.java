package com.automation.driver;

import org.openqa.selenium.WebDriver;


public class DriverManager {
	private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
	
	
public static WebDriver getDriver() {
	return driver.get();
	
}	

public static void setDriver(WebDriver driverobj) {
	
	driver.set(driverobj);
	
	
}

public static void unload() {
	
	driver.remove();
}
	
	
	
	
	
	
	
	
	
	
	
}
