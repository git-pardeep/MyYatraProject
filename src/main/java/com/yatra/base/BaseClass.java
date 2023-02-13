package com.yatra.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.yatra.utility.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static Properties prop = new Properties();
	public static FileInputStream fis;

	@BeforeSuite(groups= {"smoke","regression"})
	public void loadConfig() throws IOException {
		ExtentReport.SetExtent();
		DOMConfigurator.configure("log4j.xml");
		File file = new File(System.getProperty("user.dir")+"\\Configuration\\confi.properties");
		fis = new FileInputStream(file);
		prop.load(fis);
		System.out.println(System.getProperty("user.dir"));
	}

	public static WebDriver getDriver() {
		return driver.get();
	}
	@Parameters("browser")
	public void launchBrowser(String browsername) {
//		String browsername= prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());

		} //else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
		
		else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@AfterSuite(groups= {"smoke","regression"})
	public static void endReport() {
		ExtentReport.endReport();

	}
}
