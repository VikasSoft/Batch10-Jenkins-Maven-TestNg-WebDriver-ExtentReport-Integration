import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import cofig.ConfigManager;
import core.WebDriverManager;



public class DemoTestSite {
	
	@Test
	public void demosite()
	{
		//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = WebDriverManager.getDriver(ConfigManager.getBrowsers()[0]);
		driver.get("http://www.way2automation.com/demo.html");
	
	driver.findElement(By.xpath(".//*[@id='toggleNav']/li[7]/a")).click();
	String actualtitle = driver.getTitle();
	System.out.println("Actual Title = " +actualtitle);
	}
	
			
			

}
