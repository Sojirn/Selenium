package tests;



import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class NewTest extends WebDriverManager
{
	//Webdriver driver;
	//WebDriverManager objmngr=new WebDriverManager();
	//WebDriver driver = objmngr.launchBrowser();
	WebDriver driver;


  @Test(priority=1)
  public void titlecheck() {
	  String expectedTitle="jjkj Testing";
		String actualTitle=driver.getTitle();
		/*if(expectedTitle.equalsIgnoreCase(actualTitle))
		{
			System.out.println("Test Passed for Title");
		}
		else
		{
			System.out.println("Test Failed for title");
		}
		Assert.assertEquals(actualTitle, expectedTitle);//Hard Assert
		System.out.println("Assertion Tests");*/
		
		SoftAssert objassert=new SoftAssert();
		objassert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Assertion Tests");
		objassert.assertAll();
	  
	  
  }
  @Test(priority=2)
  public void urlCheck() {
	  String expectedUrl="https://selenium.obsqurazone.com/index.php";
		String actualUrl=driver.getCurrentUrl();
		if(expectedUrl.equalsIgnoreCase(actualUrl))
		{
			System.out.println("Test Passed for Url");
		}
		else
		{
			System.out.println("Test Failed for Url");
		}
	  
	  
  }
  @AfterMethod
  private void failedscreenshots(ITestResult result) throws IOException {
	  if(ITestResult.FAILURE==result.getStatus()) {
	  System.out.println(result.getTestName());
	  WebDriverManager objscreen = new WebDriverManager();
	  objscreen.Screenshot();
	  }
  }
  
  @Parameters({"Browser","Url"})
  @BeforeTest
  public void beforeTest(String Browser, String Url) {

  // this.driver= launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");

  this.driver= launchBrowser(Browser,Url);
  }
  @BeforeTest
  public void beforeTest() {

	  this.driver= launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");

	  //this.driver= launchBrowser(Browser,Url);
	  }
  
 // @AfterTest
// public void afterTest() {
	//  driver.close();
	  
 // }

}
