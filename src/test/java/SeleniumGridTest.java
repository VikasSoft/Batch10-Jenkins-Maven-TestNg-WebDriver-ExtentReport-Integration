import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridTest {

	@Test
	public void testSOmeThingOnGrid(){
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		//caps.setPlatform(Platform.WIN8_1);
	
		try {
			URL gridHubUrl = new URL("http://localhost:4444/wd/hub");
			WebDriver driver = new RemoteWebDriver(gridHubUrl,caps);
			
			driver.get("http://facebook.com");
			
			driver.quit();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
