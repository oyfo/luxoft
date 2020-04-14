package luxoft;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import components.ConfigReader;

public class CommonStepDefinitions extends AbstractSteps { 
	ConfigReader configReader = new ConfigReader();

	@Given("^I am on UBS homepage")
	public void openUbsHomepage() {
		ubshomepage.openHompepage(ubshomepage.getDriver());
	}
	
	@Given("I open {string} and verify header {string}")
	public void upenPage(String url, String header) {
		ubshomepage.openUrl(ubshomepage.getDriver(), url);
		ubshomepage.verifyHeader(header);
	}
	
	@Then("footer is available")
	public void footer_is_available() {
		ubshomepage.verifyBottomFooter();
	}
	
	@When("I click on {string} button")
	public void iClickOnButton(String button) {
		ubshomepage.clickButton(button);
	}

	@Then("I should be directed to {string}")
	public void iShouldBeDirectedTo(String string) {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, string );
	}

	@Given("I am on German Home UBS page")
	public void iAmOnUbsPage() {
	    ubshomepage.openUrl(driver, configReader.getProp("urls.homepageDE"));
	}
	
	@Before
	public void before() {
		createHomepage();
	}
		
    @After()
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(2000);
    	ubshomepage.quitDriver();
    }
}