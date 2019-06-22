package com.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.Util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		prop = new Properties();
		FileInputStream file1;
		try {
			file1 = new FileInputStream("D://eclipse&&&testng//FreeCRMTest//src//main//java//com//qa//config//config.properties");
			prop.load(file1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initalization(){
		String browsername =prop.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\NEW DOWNLOA\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlywait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}
	
}
