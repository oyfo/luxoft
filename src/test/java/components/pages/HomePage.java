package components.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.ConfigReader;
import components.PageObject;

public class HomePage extends PageObject{
	
	@FindBy(xpath = "//button[@class='headerLogin__toggle js-header-login-open']//span[contains(text(),'UBS logins')]")
	private static WebElement ubsLogins;
			
	@FindBy(xpath = "//a[contains(text(),'US client account login')]")
	private static WebElement usClientAccountLogin;
	
	@FindBy(xpath = "//li[@class=\"catNav__item catNav__item--level1\"]//a[contains(text(), \"Careers\")]")
	private static WebElement CareersDropdown;
	
	@FindBy(xpath = "//a[contains(text(), \"Search jobs\")]")
	private static WebElement SearchJob;
	
	ConfigReader configReader = new ConfigReader();

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, 7);
	}
	
	public void openHompepage(WebDriver driver){
		PageFactory.initElements(driver, this);
		driver.get(configReader.getProp("urls.homepage"));
		acceptCookies();
	}
	
	public void clickUbsLogins() {
		WebElement ubsl = wait.until(ExpectedConditions.elementToBeClickable(ubsLogins));
		ubsl.click();
	}
	
	public UsClientAccountLogin clickUsClientAccoutLogin() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(usClientAccountLogin)).click();
		System.out.println("odpalam konstruktor");
		return PageFactory.initElements(getDriver(), UsClientAccountLogin.class);
	}
	
    public void clicCareers() {
		wait.until(ExpectedConditions.elementToBeClickable(CareersDropdown)).click();
	}
    
	public JobBoard clickSearchJobs() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchJob)).click();
		return PageFactory.initElements(getDriver(), JobBoard.class);
	}
}