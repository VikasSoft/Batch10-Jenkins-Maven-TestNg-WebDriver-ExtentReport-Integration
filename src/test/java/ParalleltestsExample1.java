import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cofig.ConfigManager;
import core.WebDriverManager;
import utils.SyncUtils;

public class ParalleltestsExample1 {

	private static final String GOOGLE_DATA_PROVIDER="GoogleDataProvider";
	
	@Test(dataProvider=GOOGLE_DATA_PROVIDER)
	public void testGoogle(String browser, String textToSearch){
		WebDriver driver = WebDriverManager.getDriver(browser);
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys(textToSearch+Keys.ENTER);
		driver.quit();
	}
	@Test
	public void testFacebook(){
		WebDriver driver = WebDriverManager.getDriver(ConfigManager.getBrowsers()[0]);
		driver.get("http://facebook.com");
		SyncUtils.waitForSeconds(5);
		driver.quit();
		
	}
	@Test
	public void testCricInfo(){
		WebDriver driver = WebDriverManager.getDriver(ConfigManager.getBrowsers()[0]);
		driver.get("http://espncrcinfo.com");
		SyncUtils.waitForSeconds(5);
		driver.quit();
	}
	@Test
	public void testGmail(){
		WebDriver driver = WebDriverManager.getDriver(ConfigManager.getBrowsers()[0]);
		driver.get("http://gmail.com");
		SyncUtils.waitForSeconds(5);
		driver.quit();
	}
	
	@DataProvider(name=GOOGLE_DATA_PROVIDER,parallel=true)
	public Object[][] getGoogleSearchData(){
		Object[][] data = new Object[][]{{"vikas thange"},{"Aditya Kumar"},{"Amitabh Bachen"},{"Sajal Choudhary"}};
		
		return injectBrowser(data);
	}
	
	public Object[][] injectBrowser(Object[][] data){
		String[] browsers = ConfigManager.getBrowsers();
		
		Object temp [][] = new Object[data.length * browsers.length][2];
		int i=0;
		for (String browser : browsers) {
			for (int k = 0; k < data.length; k++) {	
				temp[i][0]= browser;
				temp[i][1]= data[k][0];
				i++;
			}
		}
		return temp;
	}
}
