package com.yatra.yatrapagetest;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.yatra.PageObjects.IndexPage;
import com.yatra.PageObjects.SearchFlightPage;
import com.yatra.base.BaseClass;

public class Searchflightpagetest extends BaseClass {
	IndexPage indexpage;
	SearchFlightPage searchflightpage;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","regression"})
	public void setUp(String browser) {
		launchBrowser(browser);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups= {"smoke","regression"})
	public void checking() throws Throwable {
		indexpage = new IndexPage();
		searchflightpage = indexpage.searcButon();
		searchflightpage.switchWindow();
//		searchflightpage.logInPage();

	}

}
