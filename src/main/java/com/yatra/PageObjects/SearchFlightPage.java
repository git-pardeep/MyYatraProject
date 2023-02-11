package com.yatra.PageObjects;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.ActionDriver.ActionClass;
import com.yatra.base.BaseClass;
import com.yatra.utility.Log;

public class SearchFlightPage extends BaseClass {
	ActionClass action;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement logIn;

	public SearchFlightPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void switchWindow() throws Throwable {
		Log.info(" start waindow handle test");
		String parentwindow = getDriver().getWindowHandle();
		
		Set<String> windows = getDriver().getWindowHandles();
		for (String window : windows) {
			if (!parentwindow.equals(window)) {
				Log.info("window swich done");
				getDriver().switchTo().window(window);
				Thread.sleep(2000);
				String getTitle = getDriver().getTitle();
				System.out.println(getTitle);
				String pageUrl = getDriver().getCurrentUrl();
				System.out.println(pageUrl);
				Thread.sleep(3000);
				System.out.println("title & pagURl success");
//				action.click(getDriver(), logIn);
//				Thread.sleep(5000);
//				System.out.println("loging success");
//				Thread.sleep(3000);
				Log.info(" end searchticket");
				getDriver().close();
	
			} 
		}
		System.out.println("driver close child");
		getDriver().switchTo().window(parentwindow);
		Thread.sleep(2000);
		getDriver().quit();
	}
}
//
//	public void logInPage() {
//		action.click(getDriver(), logIn);
//		System.out.println("loging success");
//		getDriver().switchTo().defaultContent();
//		getDriver().close();
//
//	}

//	public void searchFlight()  throws Throwable {
////		Set<String> windows= getDriver().getWindowHandles();
////		for(String window:windows) {
////			getDriver().switchTo().window(window);
////			Thread.sleep(2000);
////			String getTitle = getDriver().getTitle();
////			System.out.println(getTitle);
////			String pageUrl= getDriver().getCurrentUrl();
////			System.out.println(pageUrl);
//		}

//}
