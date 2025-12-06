package com.automation.utils;

import java.util.Calendar;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener {

ExtentSparkReporter sparkReporter;
ExtentReports extent;
ExtentTest test;
ConfigReader reader;
	public void onStart(ITestContext context) {
		try {
			String path= System.getProperty("user.dir");
			sparkReporter= new ExtentSparkReporter(path+"\\reports\\TestReport.html");
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setReportName("Test Automation");
			sparkReporter.config().setTheme(Theme.DARK);
			reader = new ConfigReader("config.yaml");
			extent= new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Application", reader.getValueByKey("application"));
			extent.setSystemInfo("Environment", reader.getValueByKey("environment"));
			extent.setSystemInfo("System Info", System.getProperty("os.name")+" : "+System.getProperty("os.version"));
			extent.setSystemInfo("Browser", reader.getParentChildValue("qa", "browser"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSuccess(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, "Test case is Passed:"+ result.getTestName());
	}

	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, "Test case is Failed:"+ result.getTestName());
		test.log(Status.FAIL, "Test case failure reason:"+ result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP, "Test case is Skipped:"+ result.getTestName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
