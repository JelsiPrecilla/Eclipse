package com.extent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample extends BaseClass {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;

	@BeforeClass
	public void setup() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent2.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		 test1 = extent.createTest("FlexiFunnels Project Test", "Test to validate Project Creation");

	}

	@Test
	public void name() throws IOException, AWTException {

		getDriver(1);
		maximize();

		test1.log(Status.INFO, "Starting TestCase");
        loadUrl("https://app.flexifunnels.com/login");
		

		test1.pass("Navigated to FluxiFunnels");
        
		WebElement userId = findLoatorById("email");
		sendkeys(userId	, "ashokdhasan@gmail.com");
		
		
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("flexi@321#");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		test1.pass("Succesfully Logged In");
		test1.info("Task Completed");


		WebElement ad2 = driver.findElement(
				By.xpath("//div[@class='uf-1e8hq-modal-inner']/child::button[@class='uf-1e8hq-close-button']"));
		ad2.click();

		WebElement createproject = driver.findElement(By.xpath("//button[@class='btn btn-ff-style fw-500 ml-2']"));
		createproject.click();

		WebElement sales = driver.findElement(By.xpath("//div[@class='feature_child']"));
		sales.click();
		WebElement list = driver.findElement(By.xpath("//div[@class='uf-1e8hq-notification-inner']/child::button"));
		list.click();

		WebElement pname = driver.findElement(
				By.xpath("//input[@class='form-control pnameval ng-pristine ng-untouched ng-valid ng-empty']"));
		pname.sendKeys("NEW PROJECT8");

		WebElement create = driver.findElement(By.xpath("//span[@ng-hide='saving']"));
		create.click();
        
		test1.pass("Project Created");
		
		String title = driver.getTitle();
		System.out.println(title);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement ss = driver.findElement(By.xpath("//div[@class='row mx-0 align-items-center ff_sub_hdr_mn_div']"));

		File s = ss.getScreenshotAs(OutputType.FILE);
		File d = new File("D:\\SSHOTNEW8.png");
		FileUtils.copyFile(s, d);
		test1.pass("Took a Screenshot of the created project");

		//driver.quit();
	}

	@AfterClass
	public void tearDown() {
		extent.flush();
	}

	
}
