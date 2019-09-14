package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.Base;

public class AgentPage extends Base{
	
	@FindBy(xpath="(//div[@id='listings-agent']//p//strong)[1]")
	private WebElement agentName;
	
	@FindBy(xpath = "//div[@id='listings-agent']//img[@class='agent_logo']")
	private WebElement agentLogo;
	
	@FindBy(xpath="//div[@id='listings-agent']//span[@class='agent_phone']")
	private WebElement agentPhoneNum;
	
	public AgentPage() {
		PageFactory.initElements(driver, this);
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

}
