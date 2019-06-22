package seleniumpractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Util.TestUtil;

public class RedBuspractice {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\NEW DOWNLOA\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlywait,TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		driver.findElement(By.id("src")).sendKeys("Hyderabad");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='search']/div/div[1]/div/ul/li[2]")).click();
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='search']/div/div[2]/div/ul/li[2]")).click();
		driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/div/label")).click();
		
//		 WebDriverWait wait = new WebDriverWait(driver,10);
//		 Thread.sleep(5000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("25")));
		String date = "11-May 2019";
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];	
		System.out.println(month_year);
		System.out.println(day);
		driver.findElement(By.xpath("//label[text()='Onward Date']")).click();
        List <WebElement> c1=  driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table"));	       
		       for (int i=0; i<c1.size();i++)
				{
					System.out.println(c1.get(i).getText());
					System.out.println("--------------");
				{				
						//Selecting the date				
						List<WebElement> days = driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
						for (WebElement d:days)
						{					
							
							if(d.getText().equals(day))
							{
								System.out.println(d.getText());
								d.click();
								Thread.sleep(3000);
								
							}
						}	
					
				}
}
		       Thread.sleep(10000);
		     driver.findElement(By.xpath(".//*[@id='search_btn']")).click();
		     List<WebElement> buscollection=  driver.findElements(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/ul[1]/div"));
		     System.out.println(buscollection.size()+"buses available");
		     String busName="";
		     for (WebElement result : buscollection ){
		    	 busName=result.findElement(By.className("travels lh-24 f-bold d-color")).getText();
		    	 System.out.println(busName);
		     
	}	
	
	
	}
}
	

