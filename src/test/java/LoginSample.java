import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import cofig.ConfigManager;
import core.WebDriverManager;
import utils.SyncUtils;

public class LoginSample {

	@Test
	public void demoTest(){
		
		WebDriver driver = WebDriverManager.getDriver(ConfigManager.getBrowsers()[0]);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
	}

}
