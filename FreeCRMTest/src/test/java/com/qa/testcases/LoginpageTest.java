package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.pages.FlightFinder;
import com.qa.pages.Loginpage;

public class LoginpageTest extends TestBase {
	
	Loginpage loginpage;
	FlightFinder flightfinder1;
	public LoginpageTest(){
		super();
	}

	@BeforeMethod
	public void setup(){
		initalization();
		 loginpage = new Loginpage();
	}
	
	@Test
	public void loginpagetest(){
		String title = loginpage.validatetitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
		boolean flag = loginpage.validateimg();
		Assert.assertTrue(flag);
		flightfinder1 = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
}
