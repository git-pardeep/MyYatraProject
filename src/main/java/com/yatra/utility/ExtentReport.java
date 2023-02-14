package com.yatra.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport {
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static void SetExtent() {
		htmlReporter = new ExtentHtmlReporter("C:\\java test\\MyProject\\yatraproject\\Output-Report\\YatraReports.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "YatraProject");
		extent.setSystemInfo("Tester", "Pardeep");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extent.flush();
	}
}
