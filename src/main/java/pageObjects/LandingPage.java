package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a//span[text()='My Account']")
	WebElement myAccountOption;
	
	@FindBy(xpath="//ul//li//a[text()='Login']")
	WebElement loginOption;
	
	
	public WebElement myAccount()
	{return myAccountOption;}
	
	public WebElement loginOption()
	{return loginOption;}
	
}
