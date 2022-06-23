package tests;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SearchTable extends WebDriverManager{
	WebDriver driver;
  @Test
  public void search () throws InterruptedException {
	  String check="Airi Satou";
	  WebElement tab = navigation("Table");
	  tab.click();
	  WebElement searchTable=driver.findElement(By.linkText("Table Sort And Search"));
	  searchTable.click();
	  WebElement searchText=driver.findElement(By.xpath("//input[@type='search']"));
	  searchText.sendKeys(check);
	  //Thread.sleep(3000);
	  WebElement expected=driver.findElement(By.xpath("//table[@id='dtBasicExample']/tbody/tr[1]/td[1]"));
	  String expectedText=expected.getText();
	  if(expectedText.contains(check))
	  {
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertTrue(false);
	  }


  }
  
  @BeforeTest
	public void beforeTest() {
		this.driver = launchBrowser("mozilla", "https://selenium.obsqurazone.com/index.php");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}


}
