package components.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobBoardPage extends HomePage {
	
	@FindBy(xpath = "//input[@name=\"keyWordSearch\"]")
	private static WebElement keyWordSearch;
	
	public JobBoardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public JobsUbsPage chooseRegion(String region) {
		List<WebElement> regions = driver.findElements(By.xpath("//div[@class=\"teaser-body teaser__content\"]"));
		for (int i = 0; i < regions.size(); i = i + 1) {;
			  if (regions.get(i).findElement(By.xpath("./h2//span")).getText().contentEquals(region)) {
				  regions.get(i).findElement(By.xpath(".//a[contains(text(),'Professionals')]")).click();
			  };
		}
		String currentTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(currentTab)) {
				driver.switchTo().window(tab); 
			}       
		}
		return PageFactory.initElements(getDriver(), JobsUbsPage.class);
	}
}