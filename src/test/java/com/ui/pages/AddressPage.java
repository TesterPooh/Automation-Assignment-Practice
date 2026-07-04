package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.pojos.AddressPOJO;
import com.ui.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {
	
	
	private static final  By COMPANY_LOCATOR = By.cssSelector("#company");
	private static final  By ADDRESS_LINE1_LOCATOR = By.cssSelector("#address1");
	private static final  By ADDRESS_LINE2_LOCATOR = By.cssSelector("#address2");
	private static final  By CITY_LOCATOR =By.cssSelector("#city");
	private static final  By ZIP_CODE_LOCATOR =By.cssSelector("#postcode");
	private static final  By COUNTRY_LOCATOR =By.cssSelector("#id_country");
	private static final  By HOME_PHONE_LOCATOR =By.cssSelector("#phone");
	private static final  By MOBILE_PHONE_LOCATOR =By.cssSelector("#phone_mobile");
	private static final  By ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR =By.cssSelector("#other");
	private static final  By ADDRESS_ALIAS =By.cssSelector("#alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final  By SAVEADDRESS_BUTTON_LOCATOR =By.cssSelector("#submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");
	
	
	
	public AddressPage(WebDriver driver) {
		super(driver);
		
	}
	public String SaveAddress(AddressPOJO addressPOJO) 
	{
		EnterText(COMPANY_LOCATOR, addressPOJO.getCompany());
		EnterText(ADDRESS_LINE1_LOCATOR, addressPOJO.getAddressLine1());
		EnterText(ADDRESS_LINE2_LOCATOR, addressPOJO.getAddressLine2());
		EnterText(CITY_LOCATOR, addressPOJO.getCity());
		 
	    
		EnterText(ZIP_CODE_LOCATOR, addressPOJO.getZipcode());
		EnterText(HOME_PHONE_LOCATOR, addressPOJO.getHomephone());
		EnterText(MOBILE_PHONE_LOCATOR, addressPOJO.getMobilephone());
		EnterText(ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR,addressPOJO.getAdditionalinfo());
		ClearText(ADDRESS_ALIAS);
		EnterText(ADDRESS_ALIAS, addressPOJO.getAddressalias());
		
		selectFromDropdown(STATE_DROPDOWN_LOCATOR,addressPOJO.getState());
		
		clickOn(SAVEADDRESS_BUTTON_LOCATOR);
		String newAddress = getVisibleText(ADDRESS_HEADING);
		return newAddress;
		
	}

}
