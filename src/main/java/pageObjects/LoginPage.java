package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-email")
	WebElement emailAddress;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement loginButton;
	
	public WebElement emailAddress()
	{return emailAddress;}
	
	public WebElement password()
	{return password;}
	
	public WebElement loginButton()
	{return loginButton;}
}
