package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {
public static ExtentReports extent;

public static ExtentReports getExtentReports() {
	String path ="C:/Users/DELL/eclipse-workspace/sicerepay/SincerePay/Reports/index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("Test Execution Report");
	reporter.config().setReportName("Autamation Report");
	reporter.config().setTheme(Theme.DARK);
	
	  extent = new ExtentReports();
      extent.attachReporter(reporter);
	extent.setSystemInfo("System", "DELL");
	extent.setSystemInfo("QA", "Shamprina");
	extent.setSystemInfo("Environment", "Stage");
	extent.setSystemInfo("Browser", "Chrome");
	extent.setSystemInfo("OS", "Windowa10");
	return extent;
	
}
}
