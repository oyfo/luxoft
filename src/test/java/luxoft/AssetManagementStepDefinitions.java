package luxoft;

import components.ConfigReader;
import components.pages.FundGatePage;
import components.pages.UbsFundsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssetManagementStepDefinitions extends AbstractSteps {

	private UbsFundsPage ubsFundsPage;
	private FundGatePage fundgate;
	ConfigReader configReader = new ConfigReader();

	@When("I click \"Asset Management\" dropdown and \"UBS Funds\" item")
	public void iClickDropdownAndItem() {
		ubshomepage.clickAssetManagement();
		ubsFundsPage = ubshomepage.clickUbsFunds();
	}
	
	@When("I choose \"Institutional Investors\" in \"United Kingdom\" page")
	public void iChoseCareersForProfessionalsInRegion() {
		fundgate = ubsFundsPage.choseInstitutionalInvestorsUKFunds();
	}
	
	@Then("I am on UK fundgate page")
	public void iAmOnUKFundgatePage() {
		fundgate.checkIfOnfundgateUkPage();
	}
}