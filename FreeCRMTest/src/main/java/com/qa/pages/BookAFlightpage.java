package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class BookAFlightpage extends TestBase{

	@FindBy(xpath="//input[@name='passFirst0']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='passLast0']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@name='creditnumber']")
	WebElement creditnumber;
	
	@FindBy(xpath="//input[@name='buyFlights']")
	WebElement buyFlights;
	
	public BookAFlightpage(){
		PageFactory.initElements(driver,this);
	}
	
	public void createpassengelist(String fstname,String lstname,String CCnum){
		firstname.sendKeys(fstname);
		Lastname.sendKeys(lstname);
		creditnumber.sendKeys(CCnum);
		buyFlights.click();
		
	}
	
	
	
}
