package tests;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import utility.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class RadioButton extends WebDriverManager {
	WebDriver driver;
	By inputForm = By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a");
	By radioMenu = By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[3]/a");
	By male = By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div[1]/label");
	By btnSelected = By.id("button-one");
	By displayedmsg = By.xpath("//*[@id=\"message-one\"]");

	@Test
	public void radioButton() throws InterruptedException, IOException {
		click(inputForm);
		click(radioMenu);
		click(male);
		Screenshot();
		Thread.sleep(10000);
		
		highlightelement(btnSelected);
		Screenshot();
		click(btnSelected);
		String displayedmsgValue = getText(displayedmsg);
		System.out.println(displayedmsgValue);
		if (displayedmsgValue.contains("Male")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Radio button not checked properly");
		}
	}


	@BeforeTest
	public void beforeTest() {
		 this.driver=launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
