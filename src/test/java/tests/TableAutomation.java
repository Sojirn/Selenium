package tests;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TableAutomation extends WebDriverManager {

	WebDriver driver;

	@Test
	public void tableautomation() throws InterruptedException {
		WebElement tab = navigation("Table");
		boolean checkstatus = false;
		tab.click();

		WebElement te = 
				driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[3]/a"));
		te.click();
		String text;
		String check = "mbnbnbnbn";
		for (int j = 0; j < 6; j++) {
			System.out.println("value  of j "+j);
			for (int i = 1; i <= 10; i++) {
				System.out.println("value  of i "+i);
				Boolean finde = driver.findElement
						(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[1]")).isDisplayed();
				if(finde==true)
				{
				 			text= driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[1]")).getText();
					System.out.println(text);
					
					if (text.contains(check)) {
						checkstatus = true;
						break;
					} else {
						checkstatus = false;
					}
				 }
				//System.out.println(text);
				// Assert.assertTrue(text.contains(check));

				

			
			WebElement next = driver.findElement(By.xpath("//*[@id=\"example_next\"]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			if (next.isEnabled()) {
				next.click();
				Thread.sleep(3000);
			}
		}
		}
			if (checkstatus == true) {
				Assert.assertTrue(true);
			} else if(checkstatus==false)
			{
				Assert.assertTrue(false, "Not correct");
			}
		}

	

	@BeforeTest
	public void beforeTest() {
		this.driver = launchBrowser("chrome", "https://selenium.obsqurazone.com/index.php");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
