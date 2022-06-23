package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver2) {
	// TODO Auto-generated constructor stub
	driver = driver2;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='collapsibleNavbar']/ul/li[2]/a")
	public WebElement inputform;

	@FindBy(id = "single-input-field")
	public WebElement enterMessage;

	

}
