package com.yatra.yatrapagetest;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.yatra.PageObjects.IndexPage;
import com.yatra.base.BaseClass;
import com.yatra.utility.ReadExcelXML;



public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","regression"})
	public void setUp(String browser) {
		launchBrowser(browser);
		}
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProviderClass= ReadExcelXML.class,dataProvider="testdata",groups="smoke")
	public void indexPagetest(String departFrom1 , String goinTo1 , String date) throws Throwable {
		indexPage = new IndexPage();
		indexPage.getTitle();
		indexPage.searchTicket(departFrom1 , goinTo1 , date);		
		
	}
}
