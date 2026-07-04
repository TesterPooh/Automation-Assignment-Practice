package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {
	 private static final By NO_PAYMENT_MESSAGE_LOCATOR =
	            By.xpath("//p[contains(text(),'No payment modules')]");
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	  public boolean isPaymentUnavailable() {
	        return isDisplayed(NO_PAYMENT_MESSAGE_LOCATOR);
	    }

	  
		public String getPaymentMessage() {
	        return getVisibleText(NO_PAYMENT_MESSAGE_LOCATOR);
	    }

}
