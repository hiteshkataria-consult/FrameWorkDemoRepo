package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	
	WebDriver driver;
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getName()+" execution started");
		extentTestThread.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTestThread.get().log(Status.PASS, result.getName()+" got failed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		String testMethodName = result.getName();
		extentTestThread.get().fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} 
		catch (Exception e) {e.printStackTrace();}
		try {
			String screenshotPath = takeScreenShot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotPath, testMethodName);
			}
		catch (Exception e) {e.printStackTrace();}
			
	}
	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
	}
	
	
	

}
