package components.pages;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FundGatePage extends UbsFundsPage{
	@FindBy(xpath = "//img[@alt='UBS Fund Gate Institutional / Professional - United Kingdom']")
	private static WebElement UKimageAlt;

	public FundGatePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 7);
	}

	public void checkIfOnfundgateUkPage() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, configReader.getProp("urls.fundgateUK"));
		assertNotNull(wait.until(ExpectedConditions.visibilityOf(UKimageAlt)));
	}
}