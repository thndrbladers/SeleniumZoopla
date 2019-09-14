package com.zoopla.tests;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.base.Base;
import com.zoopla.pages.AgentPage;
import com.zoopla.pages.Mainpage;
import com.zoopla.pages.PropertyDetailsPage;
import com.zoopla.pages.PropertyForSaleSearchResults;

public class SalesTest extends Base{
	
	public SalesTest() {
		super();
	}
	Mainpage mainPage;
	AgentPage agentPage;
	PropertyDetailsPage propertyDetailsPage;
	PropertyForSaleSearchResults propertyForSaleSearchResults;
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		mainPage=new Mainpage();
		propertyDetailsPage=new PropertyDetailsPage();
	}
	
	@Test(description="Printing raw prices")
	public void printAllPriceValues() {
		
		//Entering London in search and clicking on search
		propertyForSaleSearchResults=mainPage.clickOnSearchTestMainpage("London");
		
		
		//Displaying all the results in descending order
		List<Double> rawPrices=propertyForSaleSearchResults.getRawPriceListSearchResult();
		Collections.sort( rawPrices,Collections.reverseOrder());
		Iterator<Double> it=rawPrices.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Clicking on 5th element
		propertyForSaleSearchResults.selectPropertySearchResults(5);
		
		//Verifying if logo,name and agent number is displayed on PropertyDetailsPage
		Assert.assertTrue(propertyDetailsPage.checkLogoPropertyDetailsPage(),"Logo not Displayed on PropertyDetails page");
		Assert.assertTrue(propertyDetailsPage.verifyAgentName(),"Agent name not diplayed PropertyDetails Page");
		Assert.assertTrue(propertyDetailsPage.verifyAgentPhoneNumber(), "Agent phone number not diplayed on PropertyDetails page ");
		
		String agentName=propertyDetailsPage.agentName();
		String agentLogo=propertyDetailsPage.agentLogo();
		String agentPhoneNum=propertyDetailsPage.agentPhoneNumber();
		
		
		
		
		
		//Clicking on agent link
		agentPage=propertyDetailsPage.clickOnAgent();
		
		
		
		
		//Matching the value of Logo,Agent Name,Agent phone on PropertyForSaleSearchResult page to PropertyDetails page
		Assert.assertEquals(agentPage.agentLogo(),agentLogo,"AgentPage-PropertyDetailsPage - Logo not Matched");
		Assert.assertEquals(agentPage.agentName(),agentName,"AgentPage-PropertyDetailsPage - Agent Name not Matched");
		Assert.assertTrue(agentPage.agentPhoneNumber().replaceAll("\\D+", "").contains(agentPhoneNum.replaceAll("\\D+", "").substring(1)), "Miss match in Agent phone no between agent and property details page.");
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
