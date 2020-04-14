package luxoft;

import components.pages.UsClientAccountLogin;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends AbstractSteps{ 
	private UsClientAccountLogin usClientLogin;

	@When("^I click on 'UBS logins' button")
	public void openUBSlogins() {
		ubshomepage.clickUbsLogins();
	}
	
	@When("^I click on 'US client account login'")
	public void openUsClientAccountLogin() throws InterruptedException {
		usClientLogin = ubshomepage.clickUsClientAccoutLogin();
	}
	
	@When("I enter incorrect login {string} and password {string}")
	public void enterUserAndPassword(String login, String password) {
		usClientLogin.enterLogin(login);
		usClientLogin.enterPassword(password);
		usClientLogin.submitUsClientAccoutLogin();	
	}
	
	@Then("I should see warning notification")
	public void loginWarningVisible() {
		usClientLogin.loginWarningVisible();	
	}
}
