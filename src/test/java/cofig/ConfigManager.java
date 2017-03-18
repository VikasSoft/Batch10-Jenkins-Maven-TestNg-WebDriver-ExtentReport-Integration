package cofig;

import java.awt.image.RescaleOp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.common.io.Resources;

public class ConfigManager {

	private static Properties props;
	private static final String BROWSERS="BROWSERS";
	private ConfigManager(){}
	
	public static String getprop(String key){
		
		if(props==null){
			// load from file
			try {
				props = new Properties();
				//props.load(new FileInputStream(Constants.PROP_PATH));
				props.load(Resources.getResource(Constants.PROP_PATH).openStream());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props.getProperty(key);
			
	}

	public static String[] getBrowsers() {
		String browsers = getprop(BROWSERS);
		return browsers.split(",");
	}
}
