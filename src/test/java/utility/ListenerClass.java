package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerClass implements ITestListener{

	ExtentReports extent = ExtentReportGenerator.getExtentReports();
	ThreadLocal<ExtentTest> extenttest  = new ThreadLocal<ExtentTest>();
	   //to attach multiple test cases 
	
	public void onTestStart(ITestResult result) {
		ObjectRepo.test = extent.createTest(result.getClass().getName()+"=="+result.getMethod().getMethodName());
		
	    extenttest.set(ObjectRepo.test);

	}
	
	public void onTestSuccess(ITestResult result) {
		ObjectRepo.test.log(Status.PASS," Test case pass");

	}

	public void onTestFailure(ITestResult result) {
		ObjectRepo.test.log(Status.FAIL," Test case fail");

	}

	public void onTestSkipped(ITestResult result) {
		ObjectRepo.test.log(Status.SKIP," Test case skip");
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
 
}
