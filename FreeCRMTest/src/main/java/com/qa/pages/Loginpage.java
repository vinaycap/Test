 package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class Loginpage  extends TestBase{

	//Pafe Foctory
	
	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement submit;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/p[1]/img")
	WebElement img;
	//intializing page elements
	public Loginpage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatetitle(){
		return driver.getTitle();
	}
	
	public boolean validateimg(){
	return img.isDisplayed();
	}
	
	public FlightFinder login(String usr,String psd){
		username.sendKeys(usr);
		password.sendKeys(psd);
		submit.click();
		return new FlightFinder();
		
	}
	
	
	
}
