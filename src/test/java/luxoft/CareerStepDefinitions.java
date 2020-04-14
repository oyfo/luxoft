package luxoft;

import static org.junit.Assert.assertTrue;

import components.pages.JobBoardPage;
import components.pages.JobsUbsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CareerStepDefinitions extends AbstractSteps {

	private JobBoardPage jobBoardPage;
	private JobsUbsPage jobsUbsPage;
	private String notFiltered;
	private String filtered;

	@When("I click \"Careers\" dropdown and \"Search jobs\" item")
	public void iClickDropdownAndItem() {
		ubshomepage.clickCareers();
		jobBoardPage = ubshomepage.clickSearchJobs();
	}
	
	@When("I chose careers for professionals in {string}")
	public void iChoseCareersForProfessionalsInRegion(String region) {
		jobsUbsPage = jobBoardPage.chooseRegion(region);
		
	}
	
	@When("I save number of all offers")
	public void iSaveAllOffers() {
		notFiltered = jobsUbsPage.saveNumberOfOffers();
		
	}
	
	@When("I search for \"QA\" and \"Poland\"")
	public void iSearchForQaAndPoland() throws InterruptedException {
		filtered = jobsUbsPage.filterJobs();
	}

	@Then("number of filtered results shhould be smaller")
	public void numberFfFilteredResultsShhouldBeSmaller() {
		assertTrue(Integer.parseInt(notFiltered) > Integer.parseInt(filtered));
	}
}