package components;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {
	private WebDriver driver;
	ConfigReader configReader = new ConfigReader();

	public WebDriver createDriver() {
		String browser = System.getProperty("browserName");
		if (isNullOrEmpty(browser)) {
			System.out.println("Using CHROME as deafult browser");
			System.setProperty("webdriver.chrome.driver", configReader.getProp("drivers.chrome_path"));
			driver = new ChromeDriver();
		} else if ( browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", configReader.getProp("drivers.chrome_path"));
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", configReader.getProp("drivers.firefox_path"));
			driver = new FirefoxDriver();
		} else {
			System.out.println("only 'chrome' and 'firefox' browsers avaliable. using CHROME as deafult");
			System.setProperty("webdriver.chrome.driver", configReader.getProp("drivers.chrome_path"));
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

    private static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }  
}