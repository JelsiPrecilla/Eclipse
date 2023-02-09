package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends BaseClass {
	@Given("^User is on the loginpage$")
	public void user_is_on_the_loginpage() throws Throwable {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://app.flexifunnels.com/login");
		driver.manage().window().maximize();
	}

	@When("^User should login \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_should_login(String username, String password) throws Throwable {
		// pom.getLoginpage().loginwithdata(string , string2);
				// Thread.sleep(1000);
				WebElement email = driver.findElement(By.id("email"));
				email.sendKeys(username);

				WebElement pass = driver.findElement(By.id("password"));
				pass.sendKeys(password);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);

				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				WebElement ad2 = driver.findElement(By.xpath("//div[@class='uf-1e8hq-modal-inner']/child::button"));
				ad2.click();

				WebElement model = driver.findElement(By.xpath(
						"//div[@data-uf-content='checklist']/descendant::div/child::button[@class='uf-1e8hq-close-button']"));
				model.click();

				// pom.getLoginpage().loginwithdata(username, password);
		
	}

	@Then("^User should create new project$")
	public void user_should_create_new_project() throws Throwable {
		WebElement createProject = driver.findElement(By.xpath("//button[@class='btn btn-ff-style fw-500 ml-2']"));
		createProject.click();

		WebElement pName = driver.findElement(
				By.xpath("//input[@class='form-control pnameval ng-pristine ng-untouched ng-valid ng-empty']"));
		pName.sendKeys("jelsi");

		WebElement createpro = driver.findElement(By.xpath("//i[@class='fas fa-plus']"));
		createpro.click();

	}

	@Then("^User should get the title name$")
	public void user_should_get_the_title_name() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String title = driver.getTitle();
		System.out.println(title);
	}


		
	





	



	
	

	@Then("User should take a screenshot of created project")
	public void user_should_take_a_screenshot_of_created_project() throws IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement ss = driver.findElement(By.xpath("//div[@class='row mx-0 align-items-center ff_sub_hdr_mn_div']"));

		File s = ss.getScreenshotAs(OutputType.FILE);
		File d = new File("D:\\ScreenShotProject.png");
		FileUtils.copyFile(s, d);
		

		driver.quit();
}
	}



