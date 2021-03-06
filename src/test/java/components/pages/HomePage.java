package components.pages;

import org.junit.Assert;
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
	
	@FindBy(xpath = "//li[@class='catNav__item catNav__item--level1']//a[contains(text(), 'Careers')]")
	private static WebElement CareersDropdown;
	
	@FindBy(xpath = "//li[@class='catNav__item catNav__item--level1']//a[contains(text(), 'Asset Management')]")
	private static WebElement AssetManagementDropdown;
	
	@FindBy(xpath = "//a[contains(text(), 'UBS Funds')]")
	private static WebElement UBSFunds;
	
	@FindBy(xpath = "//a[contains(text(), 'Search jobs')]")
	private static WebElement SearchJob;
	
	@FindBy(xpath = "//a[@class='metaNav__hl metaNav__hl--upperCase js-language-label metaNav__hl--firstLevel metaNav__hl--upperCase--firstLevel' and contains(text(), 'DE')]")
	private static WebElement languageDE;
	
	@FindBy(xpath = "//a[@class='metaNav__hl metaNav__hl--upperCase js-language-label metaNav__hl--firstLevel metaNav__hl--upperCase--firstLevel' and contains(text(), 'EN')]")
	private static WebElement languageEN;

	ConfigReader configReader = new ConfigReader();

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, 7);
	}
	
	public void openHompepage(WebDriver driver){
		PageFactory.initElements(driver, this);
		driver.get(configReader.getProp("urls.homepageEN"));
		acceptCookies();
	}
	
	public void clickUbsLogins() {
		WebElement ubsl = wait.until(ExpectedConditions.elementToBeClickable(ubsLogins));
		ubsl.click();
	}
	
	public UsClientAccountLoginPage clickUsClientAccoutLogin() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(usClientAccountLogin)).click();
		System.out.println("odpalam konstruktor");
		return PageFactory.initElements(getDriver(), UsClientAccountLoginPage.class);
	}
    
    public void clickCareers() {
		wait.until(ExpectedConditions.elementToBeClickable(CareersDropdown)).click();
	}
    
    public void clickAssetManagement() {
		wait.until(ExpectedConditions.elementToBeClickable(AssetManagementDropdown)).click();
	}
    
	public JobBoardPage clickSearchJobs() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchJob)).click();
		return PageFactory.initElements(getDriver(), JobBoardPage.class);
	}
	
	public UbsFundsPage clickUbsFunds() {
		wait.until(ExpectedConditions.elementToBeClickable(UBSFunds)).click();
		return PageFactory.initElements(getDriver(), UbsFundsPage.class);
	}
	
	public void clickButton(String button) {
		WebElement elementToClick = null;
		if (button.equals("switch to German")){
			elementToClick = languageDE;
		}else if (button.equals("switch to English")){
			elementToClick = languageEN;
		}
		Assert.assertNotNull(elementToClick);
		wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
	}
}