package components.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UbsFundsPage extends HomePage {
	
	@FindBy(xpath = "//div[@aria-controls='ui-id-26']")
	private static WebElement institutionalInvestors;
	@FindBy(xpath = "//div[@class='basecomponent accordion__split accordionsplit ui-accordion-header ui-corner-top ui-state-default ui-accordion-icons ui-accordion-header-active ui-state-active']")
	private static WebElement selectedIcon;
	@FindBy(xpath = "//a[contains(@href,'https://fundgate.ubs.com/srprices.do?rid=6&segment=ubsf.emif&cty=GB&lang=en')]")
	private static WebElement UkInvestors;
	
	public UbsFundsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, 7);
	}

	public FundGatePage choseInstitutionalInvestorsUKFunds() {
		wait.until(ExpectedConditions.elementToBeClickable(institutionalInvestors)).click();
		wait.until(ExpectedConditions.elementToBeClickable(UkInvestors)).click();
		
		return PageFactory.initElements(getDriver(), FundGatePage.class);
	}
}