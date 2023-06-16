package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FRC {

	@FindBy(xpath="//div[@aria-disabled='false'][25]")
	private WebElement FRC;
	
	@FindBy(xpath="//div[@id='OperatorID']")
	private WebElement SELECTOPERATORR;
	
	@FindBy(xpath="//input[@autocomplete='new-password']")
	private WebElement CONSUMERNUMBERR ;

	@FindBy(xpath="//div[@aria-haspopup='listbox'][2]")
	private WebElement SELECTAMOUNT;
	
	@FindBy(xpath="//button[@type='reset']")
	private WebElement RESET;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement RECHARGE;
	
	public FRC(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void frc() {
		FRC.click();
		
	}
	public void selectoperatorr() {
		SELECTOPERATORR.click();
	}
	public void consumernumberr() {
		CONSUMERNUMBERR.sendKeys("8765423636");
	}
	public void selectamount() {
		SELECTAMOUNT.click();
	}
	public void reset() {
		RESET.click();
	}
	public void recharge() {
		RECHARGE.click();
	}
	

}
