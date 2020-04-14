package components.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UsClientAccountLogin extends HomePage {
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userInput;

	@FindBy(xpath = "//input[@id='password']")
	private static WebElement passwordInput;

	@FindBy(xpath = "//input[@id='submit']")
	private static WebElement logintBtn;

	@FindBy(xpath = "//div[contains(@class, 'error-notification')]")
	private static WebElement loginWarning;

	public UsClientAccountLogin(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, 7);
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
    
    public void loginWarningVisible() {
    	wait.until(ExpectedConditions.visibilityOf(loginWarning));
    	
    }

}
