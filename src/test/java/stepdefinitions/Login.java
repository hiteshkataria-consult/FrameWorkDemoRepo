package stepdefinitions;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.hk.automation.test.LoginTest;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import resources.Base;

public class Login extends Base {
	
	public WebDriver driver;
	Logger Log;
	LoginPage loginPage;
	LandingPage landing;
	
	@Given("^Open my broswer$")
	public void open_my_broswer() throws IOException {
		Log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		Log.debug("Browser got launched");
	}

	@And("Navigate to login page")
	public void navigate_to_login_page() {
		driver.get(prop.getProperty("Url"));
		Log.debug("Navigated to application url");

		}
	
	@And("Navigate to login page too")
	public void navigate_to_login_page_too() throws InterruptedException {
		driver.get(prop.getProperty("Url2"));
		Log.debug("Navigated to google");
		driver.get(prop.getProperty("Url"));
		Log.debug("Navigated to application url");
		landing = new LandingPage(driver);
		landing.myAccount().click();
		Log.debug("Clicked on my account dropdown");
		landing.loginOption().click();
		Log.debug("Clicked on Login option");
		}

	//"^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$"
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String email, String password) {
		
		
		loginPage = new LoginPage(driver);
		
		loginPage.emailAddress().sendKeys(email);
		Log.debug("Email address entered");
		loginPage.password().sendKeys(password);
		Log.debug("Password entered");
		loginPage.loginButton().click();
		Log.debug("Clicked on Login Button");

	}

	@Then("^Verify user is able to succesfully login$")
	public void verify_user_is_able_to_succesfully_login() {
			
		
		MyAccountPage map = new MyAccountPage(driver);
		Assert.assertTrue(map.editAccountInfo().isDisplayed());
		
		Log.debug("Login is succesful");
		Log.info("Login  test got passed");

	}
	
	@After
	public void closeBrowser()
	{
		driver.close();
	}

}
