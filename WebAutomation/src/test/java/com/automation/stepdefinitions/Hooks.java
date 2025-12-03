package com.automation.stepdefinitions;

import com.automation.base.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

BaseTest base= new BaseTest();
	
@Before
public void before() {
	
	base.setup("chrome");
}
	

@After
public void after() {
	base.tearDown();
	
}

}
