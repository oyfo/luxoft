package luxoft;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepDefinitions extends AbstractSteps { 

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
	
	@Before
	public void before() {
		createHomepage();
	}
		
    @After()
    public void closeBrowser() {
    	ubshomepage.quitDriver();
    }
}
