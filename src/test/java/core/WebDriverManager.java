package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import cofig.ConfigManager;

public class WebDriverManager {

	public static WebDriver getDriver(String browserName) {
		ConfigManager props = ConfigManager.getInstance();

		WebDriver driver = null;
		if (props.useGrid()) {
			System.out.println("Launching browser on selenium grid..");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setBrowserName(browserName);
			URL url=null;
			try {
				url = new URL(props.getGridHubUrl());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				Assert.fail("Invalid grid hub url: "+props.getGridHubUrl());
				e.printStackTrace();
			}
			
			driver = new RemoteWebDriver(url,caps);
			
		} else {
			switch (browserName.toUpperCase().trim()) {

			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", props.getprop("GECKO_DRIVER"));
				driver = new FirefoxDriver();
				break;
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", props.getprop("CHROME_DRIVER"));
				driver = new ChromeDriver();
				break;
			case "IE":
				System.setProperty("webdriver.ie.driver", props.getprop("IE_DRIVER"));
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("Invalid browser selected..");
				break;
			}
		}
		return driver;
	}

}
