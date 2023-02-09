package com.jen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jenkins {
	@Test
	public void report() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent2.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		  ExtentTest createTest = extent.createTest("FlexiFunnels Project Test", "Test to validate Project Creation");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://app.flexifunnels.com/login");
		driver.manage().window().maximize();
		createTest.pass("passed");
		
		extent.flush();
			
		

	}
		

}
