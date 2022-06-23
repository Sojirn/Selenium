package tests;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ActionsAlert extends WebDriverManager{
	WebDriver driver;
  @Test
  public void actionmove() throws InterruptedException {
	  WebElement alert=driver.findElement(By.xpath("//*[@id=\"alert-modal\"]"));
	  alert.click();
	  WebElement jsalert=driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[5]/a"));
	  jsalert.click();
	  Thread.sleep(3000);
	  
	  WebElement product = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div/div[2]/button"));
			  Actions action = new Actions(driver);
			  action.moveToElement(product).build().perform();
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
