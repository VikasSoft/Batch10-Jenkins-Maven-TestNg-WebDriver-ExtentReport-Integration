import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cofig.ConfigManager;
import core.WebDriverManager;

public class TestDemoFire {

	
	@Test
	public void logintest(){
		WebDriver driver = WebDriverManager.getDriver(ConfigManager.getBrowsers()[0]);
		driver.get("http://demo.testfire.net/");
		driver.findElement(By.linkText("ONLINE BANKING LOGIN")).click();
		driver.findElement(By.id("uid")).sendKeys("john");
		driver.findElement(By.id("passw")).sendKeys("smith");
		driver.findElement(By.name("btnSubmit")).click();
		driver.quit();
		
	}
	
}
