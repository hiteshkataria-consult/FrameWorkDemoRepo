package com.hk.automation.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;


public class Test2 extends Base{
	public WebDriver driver;
	
	@Test
	public void TestTwo() throws Exception
	{
		System.out.println("TestTwo");
		
		driver = initializeDriver();
		driver.get(prop.getProperty("Url2"));
		Thread.sleep(2000);
	//	Assert.assertTrue(false);
		driver.close();
	}
	
	

}
