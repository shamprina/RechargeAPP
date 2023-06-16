package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanPayment {

	@FindBy(xpath="//div[@aria-disabled='aria-disabled']")
	private WebElement LOANPAYMENT;
	
	@FindBy(xpath="//input[@type='text'][1]")
	private WebElement SELECTOPERATOR;
	
	@FindBy(xpath="//input[@name='ConsumerNumber']")
	private WebElement CONSUMERNUMBER;
	
	
	@FindBy(xpath="//input[@name='Amount']")
	private WebElement AMOUNT;
	
	@FindBy(xpath="//button[@type='reset']")
	private WebElement RESETBUTTON;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement PAYBUTTON;
	
	public LoanPayment(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void loanpayment() {
		LOANPAYMENT.click();
	}

	public void selectoperator() {
		SELECTOPERATOR.click();
	}
	public void consumernumber() {
		CONSUMERNUMBER.sendKeys("1234567890");
	}
	public void amount() {
		AMOUNT.sendKeys("1324");
	}
	public void reset() {
		RESETBUTTON.click();
	}
	public void paybutton() {
		PAYBUTTON.click();
	}
	
}
