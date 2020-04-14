package luxoft;

import static org.junit.Assert.assertTrue;

import components.pages.JobBoard;
import components.pages.JobsUbs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CareerStepDefinitions extends AbstractSteps {

	private JobBoard jobBoard;
	private JobsUbs jobsUbs;
	private String notFiltered;
	private String filtered;

	@When("I click \"Careers\" dropdown and \"Search jobs\" item")
	public void iClickDropdownAndItem() {
		ubshomepage.clicCareers();
		jobBoard = ubshomepage.clickSearchJobs();
	}
	
	@When("I chose careers for professionals in {string}")
	public void iChoseCareersForProfessionalsInRegion(String region) {
		jobsUbs = jobBoard.chooseRegion(region);
		
	}
	
	@When("I save number of all offers")
	public void iSaveAllOffers() {
		notFiltered = jobsUbs.saveNumberOfOffers();
		
	}
	
	@When("I search for \"QA\" and \"Poland\"")
	public void iSearchForQaAndPoland() throws InterruptedException {
		filtered = jobsUbs.filterJobs();
	}

	@Then("number of filtered results shhould be smaller")
	public void numberFfFilteredResultsShhouldBeSmaller() {
		assertTrue(Integer.parseInt(notFiltered) > Integer.parseInt(filtered));
	}
}
