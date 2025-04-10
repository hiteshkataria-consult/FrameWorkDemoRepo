package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//browser and driver management

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{	
		prop = new Properties();
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		
				
		String browserName=prop.getProperty("browser");
		
		//select browser driver
		 if(browserName.equalsIgnoreCase("chrome") ) {driver = new ChromeDriver();}
		 else if(browserName.equalsIgnoreCase("firefox") ) {driver = new FirefoxDriver();}
		 else if(browserName.equalsIgnoreCase("edge") ) {driver = new EdgeDriver();}

		 //set up browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 return driver;
		 
	}

	public String takeScreenShot(String testName,WebDriver driver) throws Exception {
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destinationFile=System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(sourceFile, new File(destinationFile));
		return destinationFile;
	}
	
	
}
