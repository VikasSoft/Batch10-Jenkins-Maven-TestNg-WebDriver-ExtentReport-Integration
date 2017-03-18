package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cofig.ConfigManager;



public class WebDriverManager {
	
	public static WebDriver getDriver(String browserName){
		
		WebDriver driver = null;
		switch(browserName.toUpperCase().trim()){
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver",ConfigManager.getprop("GECKO_DRIVER"));
				driver = new FirefoxDriver();
				break;
			case "CHROME":
				System.setProperty("webdriver.chrome.driver",ConfigManager.getprop("CHROME_DRIVER"));
				driver = new ChromeDriver();
				break;
			case "IE":
				System.setProperty("webdriver.ie.driver", ConfigManager.getprop("IE_DRIVER"));
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("Invalid browser selected..");
				break;
		}
		
		return driver;
	}

}
