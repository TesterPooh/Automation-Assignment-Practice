package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.*;
import com.constants.*;

public class ProductDetailPage  extends BrowserUtility{

	private static final By SIZE_DROPDWON_LOCATOR = By.name("group_1");
	private static final By ADD_TO_CART_LOCATOR = By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_LOCATOR= By.xpath("//a[@title= \"Proceed to checkout\"]");
	
	
	
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
	}
	public ProductDetailPage changeSize(Size size)
	{
		selectFromDropdown(SIZE_DROPDWON_LOCATOR,size.getValue());
		return new ProductDetailPage(getDriver());
	}
   public ProductDetailPage addToCart() {
	   clickOn(ADD_TO_CART_LOCATOR);
	   return new ProductDetailPage(getDriver());
   }
   public ShoppingCartPage proceedToCheckout() {
	   
	   clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
	   return new ShoppingCartPage(getDriver());
   }
}
