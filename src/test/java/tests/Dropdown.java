package tests;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Dropdown extends WebDriverManager
{
  WebDriver driver;
  
  @Test(priority=1)
  public void dropDownTest() throws InterruptedException{
	  
	  WebElement inputForm = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
	  inputForm.click();
	  Thread.sleep(3000);
	  
	  WebElement selectinput = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[4]/a"));
	  selectinput.click();
	  Thread.sleep(3000);
	  
	  /*WebElement inputForm=driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
	  inputForm.click();
	  Thread.sleep(3000);
	  
	  
	  
	 WebElement selectInput=driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[4]/a"));
	 selectInput.click();
	 Thread.sleep(3000);*/
	 
	  WebElement dropDown=driver.findElement(By.id("single-input-field"));
	  dropDown.click();
	  Thread.sleep(3000);
	  
	  Select objdrop=new Select(dropDown);
	  objdrop.selectByValue("Red");
	  Thread.sleep(3000);
	  //objdrop.deselectByValue("Red");
	  Thread.sleep(3000);
	  objdrop.selectByIndex(2);
	  Thread.sleep(3000);
	  //objdrop.deselectByIndex(2);
	  Thread.sleep(3000);
	  objdrop.selectByVisibleText("Yellow");
	  Thread.sleep(3000);
	  //objdrop.deselectByVisibleText("Yellow");
	  Thread.sleep(3000);
	  
	  /*int arr[]= {1,2,3};
	  for(int i:arr)
	  {
		 objdrop.selectByIndex(i) ;
	  }*/
	  
	  for(int i=0;i<4;i++)
	  {
		  objdrop.selectByIndex(i);
		  Thread.sleep(3000);
	  }
	  Thread.sleep(3000);
	  WebElement selectedColor=driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
	  String selectedcolorValue=selectedColor.getText();
	  if(selectedcolorValue.contains("Green"))
	  {
		 Assert.assertTrue(true); 
	  }
	  else
	  {
		  Assert.assertTrue(false,"Selected color not displayed correctly");
	  }
		  
	  
  }
  @Test(priority=2)
  public void checkBox () throws InterruptedException
  {
	WebElement  checkBox=driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[2]/a"));
	checkBox.click();
	Thread.sleep(3000);
	WebElement checkSelect=driver.findElement(By.id("gridCheck"));
	checkSelect.click();
	Thread.sleep(3000);
    WebElement msgDisplayed=driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
   String msgDisplayedValue=msgDisplayed.getText();
   String actualMsg="Success";
   if(msgDisplayedValue.contains(actualMsg))
   {
	   Assert.assertTrue(true);
   }
   else
   {
	   Assert.assertTrue(false, "Msg not matching");
   }
  }
  @Test(priority=3)
  public void radioButton() throws InterruptedException
  {
	  WebElement radioMenu=driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[3]/a"));
	  radioMenu.click();
	  Thread.sleep(3000);
	  WebElement male=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div[1]/label"));
	  male.click();
	  Thread.sleep(3000);
	  WebElement female=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div[2]/form/div[1]/div[2]/label"));
	  female.click();
	  Thread.sleep(3000);
	  WebElement btnSelected=driver.findElement(By.id("button-one"));
	  btnSelected.click();
	  Thread.sleep(3000);
	  WebElement displayedmsg=driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
	  String displayedmsgValue=displayedmsg.getText();
	  Thread.sleep(3000);
	  if(displayedmsgValue.contains("male"))
	  {
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertTrue(false,"not correct");
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
