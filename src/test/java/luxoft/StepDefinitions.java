package luxoft;

import static org.junit.Assert.assertTrue;

import components.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions { 
	private PageObject ubshomepage;
	private String notFiltered;
	private String  filtered;
	
	@Given("^I am on UBS homepage")
	public void openUbsHomepage() {
		ubshomepage.openHompepage(ubshomepage.getDriver());
	}
	
	@Given("I open {string} and verify header {string}")
	public void upenPage(String url, String header) {
		ubshomepage.openUrl(ubshomepage.getDriver(), url);
		ubshomepage.verifyHeader(header);
	}
	
	@When("^I click on 'UBS logins' button")
	public void openUBSlogins() {
		ubshomepage.clickUbsLogins();
	}
	
	@When("^I click on 'US client account login'")
	public void openUsClientAccountLogin() {
		ubshomepage.clickUsClientAccoutLogin();
	}
	
	@When("I enter incorrect login {string} and password {string}")
	public void enterUserAndPassword(String login, String password) {
		ubshomepage.enterLogin(login);
		ubshomepage.enterPassword(password);
		ubshomepage.submitUsClientAccoutLogin();	
	}
	
	@When("I click \"Careers\" dropdown and \"Search jobs\" item")
	public void iClickDropdownAndItem() {
		ubshomepage.clicCareers();
		ubshomepage.clickSearchJobs();
	}
	
	@When("I chose careers for professionals in {string}")
	public void iChoseCareersForProfessionalsInRegion(String region) {
		ubshomepage.chooseRegion(region);
		
	}
	
	@When("I save number of all offers")
	public void iSaveAllOffers() {
		notFiltered = ubshomepage.saveNumberOfOffers();
		
	}
	
	@When("I search for \"QA\" and \"Poland\"")
	public void iSearchForQaAndPoland() throws InterruptedException {
		filtered = ubshomepage.filterJobs();
	}

	@Then("number of filtered results shhould be smaller")
	public void numberFfFilteredResultsShhouldBeSmaller() {
		assertTrue(Integer.parseInt(notFiltered) > Integer.parseInt(filtered));
	}
	
	@Then("I should see warning notification")
	public void loginWarningVisible() {
		ubshomepage.loginWarningVisible();	
	}
	
	@Then("footer is available")
	public void footer_is_available() {
		ubshomepage.verifyBottomFooter();
	}
	
	@Before
	public void before() {
		String browser = System.getProperty("browserName");
		ubshomepage = new PageObject(browser);
	}
		
    @After()
    public void closeBrowser() {
    	ubshomepage.quitDriver();
    }
}
