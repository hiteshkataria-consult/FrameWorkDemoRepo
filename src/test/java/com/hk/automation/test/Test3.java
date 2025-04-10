package com.hk.automation.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class Test3 extends Base {
		
		public WebDriver driver;
	
		@Test
		public void TestThree() throws Exception
		{
			System.out.println("updated by Ritu");
			System.out.println("TestThree");
		driver = initializeDriver();
		driver.get(prop.getProperty("Url3"));
		Thread.sleep(2000);
	
		driver.close();}

	}


