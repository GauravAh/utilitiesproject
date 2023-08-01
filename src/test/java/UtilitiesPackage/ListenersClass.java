package UtilitiesPackage;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AmazonBasePackage.BaseClass;


public class ListenersClass extends BaseClass implements ITestListener {
	
	ExtentTest test;
	ExtentReports reports;

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		try {
			test.log(LogStatus.PASS, "Test Passed" + test.addScreenCapture(TakeSS()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_");
		reports = new ExtentReports("./ReportFolder/" + filename + context.getName()+  ".html");
		test = reports.startTest("Amazon Project");
	}

	public void onFinish(ITestContext context) {
		reports.endTest(test);
		reports.flush();
	}
	
	public String TakeSS() throws Exception {
		Date dd = new Date();
		String erString = dd.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot Tss1 = (TakesScreenshot)getBrowser();
		File FileSrc = Tss1.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir") + "\\ReportFolder\\" + erString + ".png";
		File FileDest = new File(filepath);
		FileUtils.copyFile(FileSrc, FileDest);
		return filepath;
	}

}
