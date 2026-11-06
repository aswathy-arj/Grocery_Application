package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryMechanism implements IRetryAnalyzer{
	
	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");
	private static final int maxTry = 2;//maxTry used to store total number of retry. maxTry is not fixed variable and can change the value
	private int count = 0;//count is to get the total count of executions

	@Override
	public boolean retry(final ITestResult iTestResult) {//boolean retry is predefined method
	if (!iTestResult.isSuccess()) {
	if (this.count < maxTry) {
	LOG.info("Retrying test " + iTestResult.getName() + " with status "
	+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
	this.count++;
	return true;
	}
	}
	return false;
	}

	public String getResultStatusName(final int status) {
	String resultName = null;
	if (status == 1) {
	resultName = "SUCCESS";
	}
	if (status == 2) {
	resultName = "FAILURE";
	}
	if (status == 3) {
	resultName = "SKIP";
	}
	return resultName;
	}

}
