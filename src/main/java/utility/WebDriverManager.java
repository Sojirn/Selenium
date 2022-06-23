package utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class WebDriverManager {
	
	//public static WebDriver driver;
	private  static WebDriver driver;

	public WebDriver launchBrowser(String browser,String url)
	{
	
		switch(browser.toLowerCase())
		{
		case  "chrome":
			System.setProperty("webdriver.chrome.driver", "E:\\seleneum\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "E:\\seleneum\\IEDriverServer.exe");  
	          
		     // Instantiate a IEDriver class.     
		driver=new InternetExplorerDriver();
		break;
		case "mozilla":
			System.setProperty("webdriver.gecko.driver","E:\\seleneum\\geckodriver.exe");
					driver = new FirefoxDriver(); 
			
			
		
		}
	
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	waitsee(10);
	return driver;

	}
	public WebDriver getdriver() {
		return this.driver;
	}
	public void waitsee(long time)
	{
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	public void waitsee(int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.HOURS);
	}
	
	
	public void click(By value) throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(value).click();
	}
	public String getText(By value) throws InterruptedException
	{
		Thread.sleep(3000);
		return driver.findElement(value).getText();
		
	}
	public void sendText(By value,String text) throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(value).sendKeys(text);
	}
	public void alertcheck(String option,String text)
	{
		Alert objalert =driver.switchTo().alert();
		if(option.equals("dismiss"))
		{
			objalert.dismiss();
		}
		if(option.equals("accept"))
		{
			objalert.accept();
		}
		if(option.equals("text"))
		{
			objalert.sendKeys(text);
			objalert.accept();
		}
	}
	
	public void Screenshot() throws IOException
{
		String finaldate=java.time.Clock.systemUTC().instant().toString().replace(":", "_");
		
			
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		
		String newt="test";
		String extention=".png";
		String filename=newt.concat(finaldate).concat(extention);
		File DestFile = new File("C:\\Users\\HOME\\eclipse-workspace\\JavaTestProject\\src\\test\\resources\\Screenshots\\"+filename);

		Files.copy(SrcFile, DestFile);
	}
	
	public void highlightelement(By value) {
		
		WebElement ele = driver.findElement(value);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: brown; border: 2px solid red;');", ele);
}
	//method implementation for similar locators

	public WebElement navigation(String ne)
	{
	 return driver.findElement(By.xpath("//a[contains(text(),'"+ne+"')]"));
	}
	public WebElement formtest(int i)
	{
	 return driver.findElement(By.xpath("//ul/li["+i+"][@class='list-group-item']/a"));
	}
    
   
	}
	 
