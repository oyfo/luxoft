package components.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobsUbs extends JobBoard{

	public JobsUbs(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, 7);
	}
	
	public String saveNumberOfOffers() {	
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@class='ladda-label' and contains(text(), 'Search')]"))));
		String allOffers = driver.findElement(By.xpath("//div[@class='sectionHeading']")).getText().split(" ")[0];
		return allOffers;
	}
	
	public String filterJobs() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='keyWordSearch']")).sendKeys("QA");
		driver.findElement(By.xpath("//input[@name='locationSearch']")).sendKeys("Poland");
		driver.findElement(By.xpath("//span[@class='ladda-label' and contains(text(), 'Search')]")).click();
		Thread.sleep(2000);
		WebElement QaPolandOffersElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='sectionHeading']"))));
		String QaPolandOffers = QaPolandOffersElement.getText().split(" ")[0];
		return QaPolandOffers;
	}
}
