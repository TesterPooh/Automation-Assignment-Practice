package com.ui.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;

import com.ui.pages.MyAccountPage;

public class SearchProductTest extends TestBase {
	private MyAccountPage  myAccountPage;
	//Hello
	private static final String SEARCH_TERM = "Printed Summer Dress";
	@BeforeMethod(description = "valid user logs into application")
	public void Setup()
	{
		myAccountPage= homePage.gotoLoginPage().doLoginWith("yigoh16329@bittnex.com","Pooh@0408");
	}
	
	
	@Test
	
	(description = "Verifies if logged in user is able to search for product and correct products",
			groups = {"e2e", "sanity", "smoke"}
	)
    public void verifyProductSearchTest()
    {  boolean actualResult= myAccountPage.searchforProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		
		Assert.assertTrue(actualResult);
		
    }
}
