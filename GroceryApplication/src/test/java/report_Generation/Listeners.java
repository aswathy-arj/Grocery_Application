package report_Generation;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.Extentreport_Utility;

public class Listeners implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = Extentreport_Utility.createExtentReports();//Extentreport_Utility -- class name
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) { // predefined methods. onTestStart() executes before clicking Run. also fetch the method name
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) { //predefined method. onTestSuccess() -- When Tc runs successfully. To show that the tc is success

		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {//onTestFailure() -- method that invoke when tc fails

		ITestListener.super.onTestFailure(result);

		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());// code with exception
		} catch (IllegalArgumentException e) {//handling exception

			e.printStackTrace(); //printStackTrace() is used to print the errors/exception
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {//parent exception. handles all
		}
	}

	public void onTestSkipped(ITestResult result) { // onTestSkipped is invoked when tc skips

		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {//onTestFailedButWithinSuccessPercentage used incase some testcases 

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {//onTestFailedWithTimeout() - failed tc due to time issues

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) { // onStart executes before onTestStart()

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) { //onFinish executes after all the above methods.

		ITestListener.super.onFinish(context);
		extent.flush(); // flush() to log the details of testcases in the report. -- (Important)
	}

}
