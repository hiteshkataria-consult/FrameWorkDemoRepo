package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentReport;
	
	public static ExtentReports getExtentReport()
	{
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("Hitesh Kataria Testing Report");
		reporter.config().setDocumentTitle("TestResults");
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("OperatingSystem", "Windows10");
		extentReport.setSystemInfo("TestedBy", "Hitesh");
	
		return extentReport;
	}

}
