package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.ui.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	
	private static final By PRODUCT_LISTING_LOCATOR = By.cssSelector("span.lighter");
	private static final By PRODUCT_LIST = By.xpath("//h5[(@itemprop= 'name')]/a");
	
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		
	}

	public String getSearchResult()
	{
		return getVisibleText(PRODUCT_LISTING_LOCATOR);
	}
	
	public boolean isSearchTermPresentInProductList(String searchTerm)
	{
	    List<String> productNameList = getAllVisibleText(PRODUCT_LIST);

	    productNameList.forEach(product ->
	            System.out.println("Product: " + product));

	    return productNameList.stream()
	            .anyMatch(product ->
	                    product.toLowerCase()
	                           .contains(searchTerm.toLowerCase()));
	}
	
	
	public ProductDetailPage clickOnProductAt(int index)
	{
		clickOn(getAllElements(PRODUCT_LIST).get(index));
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
		
	}
	
	
}
