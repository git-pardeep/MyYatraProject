package com.yatra.PageObjects;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.ActionDriver.ActionClass;
import com.yatra.base.BaseClass;
import com.yatra.utility.Log;

public class IndexPage extends BaseClass {
	ActionClass action = new ActionClass();
	@FindBy(xpath = "//input[@id='BE_flight_origin_city']")
	private WebElement departFrom;
	@FindBy(xpath = "//input[@id='BE_flight_arrival_city']")
	private WebElement goingTo;
	@FindBy(xpath = "//label[@for='BE_flight_origin_date']")
	private WebElement origindate;
	@FindBy(xpath = "//div[@id='monthWrapper']//tbody[@class='BE_flight_origin_date']//td[@class!='inActiveTD']")
	private List<WebElement> searchdate;

	@FindBy(xpath = "//span[@class='more-arr']")
	private WebElement more;
	@FindBy(xpath = "//span[normalize-space()='Freight']")
	private WebElement freight;
	@FindBy(xpath = "//div[@class='ripple-parent search-height demo-icon icon-go']//input[@id='BE_flight_flsearch_btn']")
	private WebElement searchBtn;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);

	}

	public String getTitle() {
		return getDriver().getTitle();
	}

	public SearchFlightPage searcButon() throws InterruptedException {
		Log.info(" start searctest");
		action.mouseover(getDriver(), more);
		action.click(getDriver(), freight);
		Thread.sleep(2000);
		Log.info(" end searctest");
		return new SearchFlightPage();
	}

	public void searchTicket(String departFrom1 , String goinTo1 , String date) throws InterruptedException {
		Log.info(" start searchticket");
		action.click(getDriver(), departFrom);
		Thread.sleep(2000);
		action.type(departFrom, departFrom1);
		Thread.sleep(2000);
		departFrom.sendKeys(Keys.ENTER);
		action.click(getDriver(), goingTo);
		Thread.sleep(2000);
		goingTo.sendKeys(goinTo1);
		Thread.sleep(2000);
		goingTo.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		action.click(getDriver(), origindate);
		Thread.sleep(2000);
		System.out.println(searchdate.size());
		Thread.sleep(2000);
		for (WebElement dat : searchdate) {
			if (dat.getAttribute("data-date").equals(date)) {
				dat.click();
				Thread.sleep(2000);
				Log.info(" end searchticket");
				break;
			}

		}
	}

}
