package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

import net.bytebuddy.asm.Advice.Enter;

public final class MyAccountPage  extends BrowserUtility{

	private static final By USER_NAME_LOCATOR = By.cssSelector("a.account>span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title =\"Add my first address\"]");
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	public String  getUserName ()
	{
		return getVisibleText(USER_NAME_LOCATOR);
	}
	public SearchResultPage searchforProduct(String productName) {
		EnterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		EnterSpecialKey(SEARCH_TEXT_BOX_LOCATOR,Keys.ENTER );
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		return searchResultPage;
	
	}
	public AddressPage goToAddressPage()
	{
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		return new  AddressPage(getDriver());
	}
	
	}

	
