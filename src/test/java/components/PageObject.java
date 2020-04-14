package components;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
	
	@FindBy(xpath = "//div[@class='footer__highlight footer__highlight--bottom']")
	private static WebElement bottomFooter;
	
	@FindBy(xpath = "//li[@class=\"catNav__item catNav__item--level1\"]//a[contains(text(), \"Careers\")]")
	private static WebElement CareersDropdown;
	
	@FindBy(xpath = "//a[contains(text(), \"Search jobs\")]")
	private static WebElement SearchJob;
	
	@FindBy(xpath = "//input[@name=\"keyWordSearch\"]")
	private static WebElement keyWordSearch;
	
	WebDriverWait wait;
	ConfigReader configReader = new ConfigReader();
	
	public PageObject(String browser) {
		if (isNullOrEmpty(browser)) {
			System.out.println("Using CHROME as deafult browser");
			System.setProperty("webdriver.chrome.driver", configReader.getProp("drivers.chrome_path"));
			driver = new ChromeDriver();
		} else if ( browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", configReader.getProp("drivers.chrome_path"));
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", configReader.getProp("drivers.firefox_path"));
			driver = new FirefoxDriver();
		} else {
			System.out.println("only 'chrome' and 'firefox' browsers avaliable. using CHROME as deafult");
			System.setProperty("webdriver.chrome.driver", configReader.getProp("drivers.chrome_path"));
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 7);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}


	public void openHompepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get(configReader.getProp("urls.homepage"));
		acceptCookies();
	}
	
	public void openUrl(WebDriver driver, String url) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
		acceptCookies();
	}
	
	public void acceptCookies() {
		boolean cookieFlag = false;
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie: cookies) {
			if (cookie.getName().equals(configReader.getProp("cookies.privacy.name"))) {
				cookieFlag = true;
			}
		}
		if (cookieFlag == false) {
			Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));

			Cookie c = new Cookie(
					configReader.getProp("cookies.privacy.name"),
					configReader.getProp("cookies.privacy.value"),
					configReader.getProp("cookies.privacy.domain"),
					configReader.getProp("cookies.privacy.path"),
					tomorrow);
			driver.manage().addCookie(c);
			driver.navigate().refresh();
		}
	};

	public void clickUbsLogins() {
		wait.until(ExpectedConditions.elementToBeClickable(ubsLogins)).click();
	}
	
	public void clickUsClientAccoutLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(usClientAccountLogin)).click();
	}
	
	    
    public void enterLogin(String login) {
    	wait.until(ExpectedConditions.elementToBeClickable(userInput)).sendKeys(login);
    }
    
    public void enterPassword(String password) {
    	wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
    }
    
    public void submitUsClientAccoutLogin() {
    	wait.until(ExpectedConditions.elementToBeClickable(logintBtn)).click();
    }
    
    public void clicCareers() {
		wait.until(ExpectedConditions.elementToBeClickable(CareersDropdown)).click();
	}
    
    public void clickSearchJobs() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchJob)).click();
	}
    
    public void loginWarningVisible() {
    	wait.until(ExpectedConditions.visibilityOf(loginWarning));
    	
    }
    
    public void verifyHeader(String header) {
    	WebElement headerElement = driver.findElement(By.xpath("//h1[@class=\"pageheadline__hl pageheadline__hl--small\" and contains(text(), '"+ header +"')]"));
    	wait.until(ExpectedConditions.visibilityOf(headerElement));
    }
    
    public void verifyBottomFooter() {
    	wait.until(ExpectedConditions.visibilityOf(bottomFooter));
    }
    
    public void quitDriver() {
    	driver.quit();
    }

    private static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

	public void chooseRegion(String region) {
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
