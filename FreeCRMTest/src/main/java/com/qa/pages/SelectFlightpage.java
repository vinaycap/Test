package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class SelectFlightpage  extends TestBase{
	
	
	@FindBy(xpath="//input[@name='reserveFlights']")
	WebElement continueonSF;
	
	
	
	
	public SelectFlightpage(){
		PageFactory.initElements(driver,this);
	}
	
	public BookAFlightpage continueSFP(){
		continueonSF.click();
		return new BookAFlightpage();
	}

}
