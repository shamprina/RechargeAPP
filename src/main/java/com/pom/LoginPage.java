package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath="//input[@name='UserName']")  
	private WebElement USERN;
	
	@FindBy(xpath="//input[@name='Password']")
	private WebElement PASSWORD;
	
	@FindBy(xpath="//span[@class='MuiButton-label-271']")
	private WebElement LOGGINBUTTON;
	
	public LoginPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	}
	
    public void clickonusername(String username) {
    	USERN.sendKeys(username);
    }
    public void pass(String pass) {
    	PASSWORD.sendKeys(pass);
    }
    public void loggin() {
    	LOGGINBUTTON.click();
    }
	
}
