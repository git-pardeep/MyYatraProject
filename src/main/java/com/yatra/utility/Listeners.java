package com.yatra.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.yatra.base.BaseClass;

public class Listeners extends ExtentReport implements ITestListener {
	public void onTestStart(ITestResult result) {
		test=extent.createTest("Test passed" + result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,"Pass Test case is: "+result.getName());
		}

	}
	public void onStart(ITestContext result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"test failure is : -" , ExtentColor.RED));
				Date currentdate = new Date();
				String screendate = currentdate.toString().replace(" ", "-");
				File screenshot = ((TakesScreenshot)BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);


//				FileUtils.copyFile(screenshot, new File("C:\\java test\\MyProject\\yatraproject\\ScreenShots\\"+screendate+ " -" +result.getName()  +".png"));
				String path ="C:\\java test\\MyProject\\yatraproject\\ScreenShots\\yatra.png"; 
						test.fail("Screenshot attched" , MediaEntityBuilder.createScreenCaptureFromPath("C:\\java test\\MyProject\\yatraproject\\ScreenShots\\yatra.png").build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()== ITestResult.SKIP) {
			test.log(Status.SKIP , "test is skippage" +result.getName());

		}

	}




	public void onFinish(ITestContext result) {



	}
}
