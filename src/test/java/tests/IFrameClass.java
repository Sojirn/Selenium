package tests;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class IFrameClass  extends WebDriverManager{
	WebDriver driver;
  @Test
  public void iframe() throws InterruptedException {
	  WebElement iframe=driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe"));
	  driver.switchTo().frame(iframe);
	  Thread.sleep(3000);
	  WebElement javascript= driver.findElement(By.linkText("JAVASCRIPT"));
	  javascript.click();
	  Thread.sleep(5000);
	  driver.switchTo().defaultContent();
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,600)");
	  Thread.sleep(5000);
	  //javascriptwaitimplementation
	  // js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
	  //javascriptclick
	  // js.executeScript("arguments[0].click();", element);
  }
  @BeforeTest
  public void beforeTest() {
	  this.driver=launchBrowser("chrome","https://www.w3schools.com/html/html_iframe.asp");
	  waitsee(50000);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
