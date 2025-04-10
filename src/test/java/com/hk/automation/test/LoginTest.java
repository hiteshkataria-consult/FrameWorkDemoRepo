package com.hk.automation.test;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	Logger Log;
	
	@BeforeMethod
	public void openApplication() throws IOException
	{
		Log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		Log.debug("Browser got launched");
		driver.get(prop.getProperty("Url"));
		Log.debug("Navigated to application url");
	}
	
	@Test(dataProvider = "getLoginData")
	public void login(String username, String password, String expected) throws IOException
	{
		LandingPage landing = new LandingPage(driver);
		landing.myAccount().click();
		Log.debug("Clicked on my account dropdown");
		landing.loginOption().click();
		Log.debug("Clicked on Login option");
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.emailAddress().sendKeys(username);
		Log.debug("Email address entered");
		loginPage.password().sendKeys(password);
		Log.debug("Password entered");
		loginPage.loginButton().click();
		Log.debug("Clicked on Login Button");
		
		MyAccountPage map = new MyAccountPage(driver);
		String actual=null;
		try {
		if (map.editAccountInfo().isDisplayed())
		{actual = "Success";
		Log.debug("Login is succesful");}
		
		}catch (Exception e)
		{actual = "Failure";
		Log.debug("Login Failed!");}
		
		Assert.assertEquals(actual, expected);
		Log.info("Login  test got passed");
			
		}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data = {{"testertest@email.com","test123","Success"},{"testertest@email.com","test342","Failure"}};
		return data;
	}
	
		
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		Log.info("Browser closed");
	}

}
