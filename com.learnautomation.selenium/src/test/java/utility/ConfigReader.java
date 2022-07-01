package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties pro;

	public ConfigReader() {

		try {
			
			FileInputStream fis = new FileInputStream(new File("./Configuration/config.properties"));

			pro = new Properties();

			pro.load(fis);

		} catch (Exception e) {

			System.out.println("Unable to load config file");
		}
	}
	
	public String getApplicationURL()
	{
		
		return pro.getProperty("ApplicationURL");
		
	}
	public String getBrowser()
	{
		
		return pro.getProperty("Browser");
		
	}

}
