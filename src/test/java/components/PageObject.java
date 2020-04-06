package components;

import java.util.concurrent.TimeUnit;
import parameters.generalParameters;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {
	private WebDriver driver;
	@FindBy(xpath = "//button[@class='headerLogin__toggle js-header-login-open']//span[contains(text(),'UBS logins')]")
	private static WebElement ubsLogins;
			
	@FindBy(xpath = "//a[contains(text(),'US client account login')]")
	private static WebElement usClientAccountLogin;
	
	@FindBy(xpath = "//input[@id='username']")
	private static WebElement userInput;

	@FindBy(xpath = "//input[@id='password']")
	private static WebElement passwordInput;

	@FindBy(xpath = "//input[@id='submit']")
	private static WebElement logintBtn;

	@FindBy(xpath = "//div[contains(@class, 'error-notification')]")
	private static WebElement loginWarning;
	
	WebDriverWait wait;
	
	public PageObject(String browser) {
		if (isNullOrEmpty(browser)) {
			System.out.println("Using CHROME as deafult browser");
			System.setProperty("webdriver.chrome.driver", generalParameters.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
		} else if ( browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", generalParameters.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", generalParameters.FIREFOXDRIVER_PATH);
			driver = new FirefoxDriver();
		} else {
			System.out.println("only 'chrome' and 'firefox' browsers avaliable. using CHROME as deafult");
			System.setProperty("webdriver.chrome.driver", generalParameters.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
		}
		Point targetPosition = new Point(1, 1);
		driver.manage().window().setPosition(targetPosition);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 18);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}


	public void openHompepageAndAcceptCookies(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get(generalParameters.HOMEPAGE);
		WebElement iframe = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(iframe);
		WebElement agree = driver.findElement(By.xpath("//span[contains(text(),'Agree to all')]"));
		agree.click();
		driver.switchTo().defaultContent();
	};
	
	//private void clickElement(WebElement element) {
	//	wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		
	//}
	public void clickUbsLogins() {
		wait.until(ExpectedConditions.elementToBeClickable(ubsLogins)).click();
	}
	
	public void clickUsClientAccoutLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(usClientAccountLogin)).click();
	//	clickElement(usClientAccountLogin);
	}
	
	    
    public void enterLogin(String login) {
    	wait.until(ExpectedConditions.elementToBeClickable(userInput)).sendKeys(login);
    }
    
    public void enterPassword(String password) {
    	wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
    }
    
    public void submitUsClientAccoutLogin() {
    	wait.until(ExpectedConditions.elementToBeClickable(logintBtn)).click();
    	//clickElement(logintBtn);
    }
    
    public void loginWarningVisible() {
    	wait.until(ExpectedConditions.visibilityOf(loginWarning));
    	
    }
    
    
    public void quitDriver() {
    	driver.quit();
    }

    private static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
}
