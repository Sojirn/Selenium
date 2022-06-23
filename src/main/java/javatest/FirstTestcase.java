package javatest;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestcase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\seleneum\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.close();*/
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\seleneum\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/index.php");
		String expectedTitle="Obsqura Testing";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equalsIgnoreCase(actualTitle))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		driver.close();
		

	}

}
