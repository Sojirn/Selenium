package tests;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class ActionsInput  extends WebDriverManager {
	WebDriver driver;
  @Test
  public void actiontest() throws InterruptedException{
	   WebElement inputForm=driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
		 
		  Thread.sleep(3000);
		  
		  
		Actions action=new Actions(driver);
		 
		  action.moveToElement(inputForm).click().build().perform();
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-input-field\"]")));
		  
		  WebElement enterMessage=driver.findElement(By.xpath("//*[@id=\"single-input-field\"]"));
		  action.moveToElement(enterMessage).click().build().perform();
		  
		  
		 
		 enterMessage.sendKeys("hello");
		 Thread.sleep(5000);
		 enterMessage.sendKeys(Keys.TAB);

	
		 Thread.sleep(3000);
		
		
		 
		   
		  Thread.sleep(3000);
		  WebElement showMessage=driver.findElement(By.xpath("//*[@id=\"button-one\"]"));
		  action.moveToElement(showMessage).click().build().perform();
		  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  this.driver=launchBrowser("chrome","https://selenium.obsqurazone.com/bootstrap-alert.php");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
