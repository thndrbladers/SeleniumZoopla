package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.Base;

public class PropertyForSaleSearchResults extends Base{
	
	
//	@FindBy(xpath="//div[@class='listing-results-right clearfix']/a[@class='listing-results-price text-price']")
	@FindBy(xpath="//ul[contains(@class,'listing-results ')]/li[contains(@class,'srp clearfix')]//a[contains(@class,'listing-results-price')]")
	private List<WebElement> rawPriceElements;
	
	public PropertyForSaleSearchResults() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public List<Double> getRawPriceListSearchResult(){
		
		List<Double> priceList = new ArrayList<Double>();
		
		Iterator<WebElement> i= rawPriceElements.iterator();
		while(i.hasNext()) {
			priceList.add(Double.parseDouble(i.next().getText().replaceAll("\\D+","")));
		}
		
		return priceList;
	}
	
	public PropertyDetailsPage selectPropertySearchResults(int propertyNum) {
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click()",rawPriceElements.get(propertyNum)); 
		
		return new PropertyDetailsPage();
		
	}

}
