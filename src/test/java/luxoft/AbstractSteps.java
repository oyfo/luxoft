package luxoft;

import org.openqa.selenium.WebDriver;

import components.Utils;
import components.pages.HomePage;

public class AbstractSteps {
	protected WebDriver driver;
	protected static HomePage ubshomepage;

	public void createHomepage() {
		Utils utils = new Utils();
	 	driver  = utils.createDriver();
	 	ubshomepage = new HomePage(driver);
	}
}