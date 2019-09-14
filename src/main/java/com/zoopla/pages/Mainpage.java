package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.Base;

public class Mainpage extends Base {
	
	@FindBy(xpath="//input[@id='search-input-location']")
	private WebElement searchInputLocation;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchButton;
	
	public Mainpage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public PropertyForSaleSearchResults clickOnSearchTestMainpage(String location) {
		searchInputLocation.sendKeys(location);
		searchButton.click();
		
		return new PropertyForSaleSearchResults();
	}
	

}
