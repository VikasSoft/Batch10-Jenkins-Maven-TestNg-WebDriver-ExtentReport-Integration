package cofig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.common.io.Resources;

public class ConfigManager {

	private static ConfigManager configInstance;
	private Properties props;
	private static final String BROWSERS = "BROWSERS";
	private static final String USE_GRID = "USE_GRID";
	private static final String GRID_HUB_URL = "GRID_HUB_URL";

	private ConfigManager() {
		props = new Properties();
	}
	
	public static ConfigManager getInstance(){
		
		if (configInstance == null) {
			// load from file
			try {
				configInstance = new ConfigManager();
				// props.load(new FileInputStream(Constants.PROP_PATH));
				configInstance.props.load(Resources.getResource(Constants.PROP_PATH).openStream());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return configInstance;
	}
	public String getprop(String key) {

		
		return getInstance().props.getProperty(key);

	}

	public boolean useGrid() {
		try {
			String value = getprop(USE_GRID);
			return Boolean.parseBoolean(value);
		} catch (Exception e) {
			return false;
		}
	}

	public String getGridHubUrl() {
		return getprop(GRID_HUB_URL);

	}

	public String[] getBrowsers() {
		String browsers = getInstance().props.getProperty(BROWSERS);
		return browsers.split(",");
	}
}
