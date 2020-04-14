package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties properties = new Properties();
	public ConfigReader(){
		try (InputStream input = new FileInputStream("src/test/resources/settings.properties")) {
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public String getProp(String property) {
		return properties.getProperty(property);
	}
}

