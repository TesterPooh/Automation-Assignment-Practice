package com.ui.test;

import static com.constants.Size.*;

import javax.naming.directory.SearchResult;

import org.testng.Assert;
import org.testng.annotations.*;

import com.constants.Size;
import com.ui.pages.PaymentPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;
	PaymentPage payment;

	@BeforeMethod(description = "User Logs into the application and searches for the product")
	public void setup() {

		searchResultPage = homePage.gotoLoginPage().doLoginWith("yigoh16329@bittnex.com", "Pooh@0408")
				.searchforProduct(SEARCH_TERM);

	}

	@Test(description = "Verify valid user is able to buy the prodcut ", groups = { "e2e", "smoke", "sanity" })
	public void checkoutTest() {
		payment =searchResultPage.clickOnProductAt(1).changeSize(Size.M).addToCart().proceedToCheckout().goToConfirmAddressPage()
				.goToShipmentPage().goToPaymentPage();
		Assert.assertTrue(payment.isPaymentUnavailable());

		Assert.assertEquals(payment.getPaymentMessage(), "No payment modules have been installed.");
	}

}
