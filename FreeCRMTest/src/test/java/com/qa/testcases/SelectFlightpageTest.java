package com.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Util.TestUtil;
import com.qa.pages.BookAFlightpage;
import com.qa.pages.FlightFinder;
import com.qa.pages.Loginpage;
import com.qa.pages.SelectFlightpage;

public class SelectFlightpageTest extends TestBase{

	Loginpage loginpage;
	FlightFinder flightfinder1;
	SelectFlightpage selectflight1;
	BookAFlightpage bookaflight1;
	String sheetname="Sheet1";
	
	
	public SelectFlightpageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initalization();
		loginpage = new Loginpage();
		flightfinder1= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		flightfinder1.selectoneway();
		flightfinder1.selectpassengers();
	String Flightfindertitle = flightfinder1.VerifyFlightFinderTitle();
	System.out.println(Flightfindertitle);
		Assert.assertEquals(Flightfindertitle,"Find a Flight: Mercury Tours:" );
		selectflight1=flightfinder1.clickcontinue();
		
	}
	
	@DataProvider
	public Object[][] getmercurytestdata() throws InvalidFormatException{
		Object data[][]= TestUtil.gettestdata(sheetname);
		return data;
	}
	
	
	
	@Test(dataProvider="getmercurytestdata")
	public void continueonSFPTes(String fn,String ln,String num){
		
		 selectflight1.continueSFP();
		bookaflight1.createpassengelist(fn,ln,num);
	}
	
	
	
	@AfterMethod
	public void teardow(){
		driver.quit();
	}
	
	
	
	
}
