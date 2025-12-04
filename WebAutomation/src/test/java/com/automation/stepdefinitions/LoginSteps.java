package com.automation.stepdefinitions;

import io.cucumber.java.en.Given;

public class LoginSteps {
	


@Given("User is on Login page")
public void user_is_on_login_page() throws InterruptedException {
	 System.out.println("Login Page");
	  Thread.sleep(5000);

}
}