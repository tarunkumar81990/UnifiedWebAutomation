package com.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	private static Driverfactory instance = null;

	private Driverfactory() {

	}

	public static Driverfactory getInstance() {
		if (instance == null) {
			instance = new Driverfactory();
		}

		return instance;
	}
	
	public WebDriver CreateDriver(String browser) {
		switch(browser) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			//options.addArguments("--disable-infobars");
			options.addArguments("--remote-allow-origins=*");
			return new ChromeDriver(options);
			
		case "firefox"	:
			return new FirefoxDriver();
			
		default: 
			throw new RuntimeException("Invalid browser"+browser) ;
			
		}	
	}
	
	
	
	

}
