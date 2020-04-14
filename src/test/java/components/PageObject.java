package components;


import java.util.Date;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {
	protected WebDriver driver;

	@FindBy(xpath = "//div[@class='footer__highlight footer__highlight--bottom']")
	private static WebElement bottomFooter;
	
	protected WebDriverWait wait;
	ConfigReader configReader = new ConfigReader();
	
	public PageObject(WebDriver driver) {
		this.driver = driver;	
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
}