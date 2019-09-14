package com.zoopla.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.Base;

public class PropertyDetailsPage extends Base {
	
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper']//h4[@class='ui-agent__name']")
	WebElement agentName;
	
	@FindBy(xpath="//div[@class='ui-agent__logo']//img[@class='js-lazy-loaded']")
	WebElement agentLogo;
	
	@FindBy(xpath="//div[@class='dp-grid-wrapper']//p[@class='ui-agent__tel ui-agent__text']//a[1]")
	WebElement agentPhoneNum;
	
	public PropertyDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkLogoPropertyDetailsPage() {
		
		return agentLogo.isDisplayed();
	}
	
	public boolean verifyAgentName() {
		
		return agentName.isDisplayed();
	}
	
	public boolean verifyAgentPhoneNumber() {
		
		return agentPhoneNum.isDisplayed();
	}
	
	public String agentName() {
		
		return agentName.getText();
	}
	
	public String agentPhoneNumber() {
		
		return agentPhoneNum.getText();
		
	}
	
	public String agentLogo() {
		return agentLogo.getAttribute("src");
	}
	
	public AgentPage clickOnAgent() {
		agentName.click();
		return new AgentPage();
	}
	
}
