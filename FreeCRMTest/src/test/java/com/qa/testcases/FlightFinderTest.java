package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.pages.FlightFinder;
import com.qa.pages.Loginpage;

public class FlightFinderTest extends TestBase {
	Loginpage loginpage;
	FlightFinder flightfinder1;
	public FlightFinderTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initalization();
		loginpage = new Loginpage();
		flightfinder1= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void FlightFinderpagetest(){
		flightfinder1.selectoneway();
		flightfinder1.selectpassengers();
	String Flightfindertitle = flightfinder1.VerifyFlightFinderTitle();
	System.out.println(Flightfindertitle);
		Assert.assertEquals(Flightfindertitle,"Find a Flight: Mercury Tours:" );
		flightfinder1.clickcontinue();
	}
	
	@AfterMethod
	public void teardow(){
		driver.quit();
	}
	
}
