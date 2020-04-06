package luxoft;


import components.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions { 
	private PageObject ubshomepage;
	
	@Given("^I am on UBS homepage")
	public void openUbsHomepage() {
		ubshomepage.openHompepageAndAcceptCookies(ubshomepage.getDriver());
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
	
	@Then("I should see warning notification")
	public void loginWarningVisible() {
		ubshomepage.loginWarningVisible();	
	}
	
	@Before
	public void before() {
		String browser = System.getProperty("browserName");
		ubshomepage = new PageObject(browser);
	}
	
    @After()
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(2000);
    	ubshomepage.quitDriver();
    }
}
