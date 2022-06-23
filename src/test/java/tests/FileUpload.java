package tests;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class FileUpload extends WebDriverManager {
	WebDriver driver=getdriver();
	String Value;
  @Test
  public void upload() throws AWTException, InterruptedException {
	   //file upload using input
	  
	  //driver.findElement(By.id("file-upload")).sendKeys("D:\\Selenium\\Pictures\\test.pdf");
	 
  StringSelection s = new StringSelection("D:\\Selenium\\Pictures\\test.pdf");
 //Clipboard copy
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
//identify element and click
	driver.findElement(By.xpath("//*[text()='Choose CV']")).click();
	Thread.sleep(10000);
 //Robot object creation
	Robot r = new Robot();
//pressing enter
r.keyPress(KeyEvent.VK_ENTER);
//releasing enter
r.keyRelease(KeyEvent.VK_ENTER);
//pressing ctrl+v
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
//releasing ctrl+v
r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_V);
//pressing enter
r.keyPress(KeyEvent.VK_ENTER);
//releasing enter
r.keyRelease(KeyEvent.VK_ENTER);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  this.driver=launchBrowser("chrome", "https://www.monsterindia.com/seeker/registration");
	 
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
