package tests;

import org.testng.annotations.Test;

import Excel.ExcelCode;
import Excel.ExcelRead;
import pagefactory.HomePage;
import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class NewTestVerify extends WebDriverManager{
	WebDriver driver;
	ExcelCode object=new ExcelCode();
	
	//By entermessage = By.xpath("//*[@id=\"single-input-field\"]");
	@Test(priority=3, enabled = true, dataProvider="SearchProvider")
  public void checkText(String test,String searchKey) throws InterruptedException, IOException {
	  
	//pagefactory implementation
	  String expected = searchKey;
	  HomePage objhome = new HomePage(driver);
	  objhome.inputform.click();
	  Thread.sleep(3000);
	  objhome.enterMessage.sendKeys(expected);
	  Thread.sleep(3000);
	  //WebElement inputForm=driver.findElement(By.linkText("Input Form"));
	  
	 // WebElement inputForm=driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
	 // inputForm.click();
	  Thread.sleep(3000);
	  //WebElement enterMessage=driver.findElement(By.xpath("//*[@id=\"single-input-field\"]"));
	  //sendText(entermessage,expected);
	   //enterMessage.sendKeys("Hello");
	  Thread.sleep(3000);
	  WebElement showMessage=driver.findElement(By.xpath("//*[@id=\"button-one\"]"));
	  showMessage.click();
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message-one\"]")));
	  //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"messagee-one\"]"))));
	 
	 String displayedText=driver.findElement(By.xpath("//*[@id=\"message-one\"]")).getText();
	 if(displayedText.contains(expected))
	 {
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 Assert.assertTrue(false, "Text entered not matching");
	 }
	}
  
  @Test(priority=4,enabled=true)
  public void addCheck() throws InterruptedException
  {
	  int a=10;
	  WebElement valuea=driver.findElement(By.id("value-a"));
	  valuea.sendKeys(String.valueOf(a));
	  
	  Thread.sleep(3000);
	  WebElement valueb=driver.findElement(By.id("value-b"));
	  int b=20;
	  valueb.sendKeys(String.valueOf(b));
	  Thread.sleep(3000);
	  WebElement getTotal=driver.findElement(By.id("button-two"));
	  getTotal.click();
	  Thread.sleep(3000);
	  //WebElement addText=driver.findElement(By.id("message-two"));
	  WebElement addText=driver.findElement(By.xpath("//*[@id=\"message-two\"]"));
	  
	  
	  
	  String displayAddText=addText.getText();
	  Thread.sleep(3000);
	  int c=a+b;
	   if(displayAddText.contains(String.valueOf(c)))
	   {
		   Assert.assertTrue(true, "Text entered is correct");
	   }
	   else
	   {
		   Assert.assertTrue(false, "Text entered is not correct");
	   }
	  
  }
  /*@BeforeTest
  public void beforeTest() {
	 // this.driver=launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");
	  this.driver=getdriver();
  }*/
  
  
  @BeforeTest
  public void beforeTest() {

  this.driver= launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");

  
  }

  @AfterTest
  public void afterTest() {
	  this.driver.close();
  }
  @DataProvider(name="SearchProvider")
  public Object[][] getDataFromDataprovider(){
  return new Object[][]
  {
  { "Shamna", "India" },
  { "Krishna", "UK" },
  { "Bhupesh", "USA" }
  };

}
}