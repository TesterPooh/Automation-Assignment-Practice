package com.ui.test;

import org.testng.annotations.BeforeMethod;

import com.ui.pages.AddressPage;
import com.ui.pages.ConfirmAddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPOJO;
import com.ui.utility.*;

import org.testng.Assert;
import org.testng.annotations.*;

public class AddNewAddressTest extends TestBase {
	
	private MyAccountPage myAccountPage;

	private AddressPOJO address;
	private AddressPage addressPage;
	
	@BeforeMethod(description = "valid first time user logs into application and adding address for the first time")
	public void Setup()
	{
		myAccountPage= homePage.gotoLoginPage().doLoginWith("docore4542@icotz.com","Anshu@1234");
	    address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addNewAddress()
	{
		
		String newAddress= myAccountPage.goToAddressPage().SaveAddress(address);
		
		Assert.assertEquals(newAddress, address.getAddressalias().toUpperCase());
		
	}

}
