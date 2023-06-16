package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCard {

	@FindBy(xpath="//div[@role='button'][20]")
    private WebElement CREDITCARD;

	@FindBy(xpath="//div[@aria-haspopup='listbox']")
	private WebElement SELECTNETWORK;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement CARDHOLDERNAME;
	
	@FindBy(xpath="//input[@name='CardNumber']")
	private WebElement CARDNUMBER;
	
	
	@FindBy(xpath="//input[@name='MobileNumber']")
	private WebElement MOBILENUMBER;
	
	@FindBy(xpath="//input[@name='Amount']")
	private WebElement AMOUNT;
	
	@FindBy(xpath="//button[@title='Reset']")
	private WebElement RESETBUTTON;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement PROCEEDBUTTON;
	
	public CreditCard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    public void creditcard() {
    	CREDITCARD.click();
    }
	public void selectnetwork() {
		SELECTNETWORK.click();
	}

	public void cardholdername() {
		CARDHOLDERNAME.sendKeys("shamprina");
	}
	public void cardnumber() {
		CARDNUMBER.sendKeys("1234567812345678");
	}
	public void mobilenumber() {
		MOBILENUMBER.sendKeys("8791233217");
	}
	public void amount() {
		AMOUNT.sendKeys("2314");
	}
	public void resetbutton() {
		RESETBUTTON.click();
	}
	public void proceedbutton() {
		PROCEEDBUTTON.click();
	}
	

}
