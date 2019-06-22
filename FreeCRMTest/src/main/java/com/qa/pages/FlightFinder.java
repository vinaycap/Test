package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.TestBase;

public class FlightFinder extends TestBase {

	
	@FindBy(xpath="//b//font//input[1]")
	WebElement roundtrip;
	
	@FindBy(xpath="//b//font//input[1]")
	WebElement onewaytrip;
	
	@FindBy(xpath="//select[@name='passCount']")
	WebElement Passengers;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement continuebutton;
	
	public FlightFinder(){
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public String VerifyFlightFinderTitle(){
		return driver.getTitle();
	}
	
	public void selectoneway(){
		onewaytrip.click();
	}
	
	public void selectpassengers(){
		Select passcount= new Select(Passengers);
		passcount.selectByVisibleText("2");
	}
	
	public   SelectFlightpage clickcontinue(){
		continuebutton.click();
		return new SelectFlightpage();
	}
	
	
	
}
