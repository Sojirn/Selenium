package tests;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class NewTest1 extends WebDriverManager{
	WebDriver driver;
	//implementing function for locators with similar xpsth
	
  @Test
  public void methodcheck() throws InterruptedException {
	  navigation("Input Form").click();
	  Thread.sleep(10000);
	  formtest(3).click();
	  Thread.sleep(10000);
	  
	  
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
