package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{

	 private static final By EMAIL_TEXT_LOCATOR = By.cssSelector("#email");
	 private static final By PASSWORD_TEXT_LOCATOR  = By.cssSelector("#passwd");
	 private static final By SUBMIT_TEXT_LOCATOR = By.cssSelector("#SubmitLogin");
	 private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	public MyAccountPage doLoginWith(String emailAddress,String Password) {
	 EnterText(EMAIL_TEXT_LOCATOR, emailAddress);
	 EnterText(PASSWORD_TEXT_LOCATOR, Password);
	 clickOn(SUBMIT_TEXT_LOCATOR);
	
	 MyAccountPage myAccountPage = new MyAccountPage(getDriver());
	 return myAccountPage;
		
	}
	public LoginPage doLoginWithInvalidCredentials(String emailAddress,String Password) {
		 EnterText(EMAIL_TEXT_LOCATOR, emailAddress);
		 EnterText(PASSWORD_TEXT_LOCATOR, Password);
		 clickOn(SUBMIT_TEXT_LOCATOR);
		 LoginPage loginPage = new LoginPage(getDriver());
		 return loginPage;
		 
	}
	public String getErrorMessage()
	{
		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}
	
	
}
