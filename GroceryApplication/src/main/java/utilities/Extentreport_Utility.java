package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport_Utility {
	
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extent reports that can
	// be shared across the application //two classes helps to generate report. obj creation

	public synchronized static ExtentReports createExtentReports() //method
	{

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//./ -- to get the local path of extent report. extent-reports is folder
		reporter.config().setReportName("7RMartSupermarketProject");//set a name
		extentReports.attachReporter(reporter);//attach to extent reports using attachReporter

		extentReports.setSystemInfo("Organization", "Obsqura");//using setSystemInfo() can provide details
		extentReports.setSystemInfo("Name", "Aswathy Nandakumar"); 
		extentReports.setSystemInfo("Designation", "Software Tester");// provides context of the report
		return extentReports;
	}

}
