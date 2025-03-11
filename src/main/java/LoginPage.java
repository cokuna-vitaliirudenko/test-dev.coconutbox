import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@placeholder='Benutzername']")
    private WebElement emailInputField;
    @FindBy(xpath = "//*[@placeholder='Passwort']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@class='btn-std btn-secondary btn-blue']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'Der Benutzername und/oder das Passwort sind falsch.')]")
    WebElement alertMessage;
    @FindBy(xpath = "//div[contains(text(),'Bitte geben Sie Ihre vollständigen Anmeldedaten ein.')]")
    WebElement emptyAlertMessage;

    public void waitForAlertMessage() {
        getWait().forVisibility(alertMessage);
        assertTrue(alertMessage.isDisplayed());
    }

    public void waitForEmptyAlertMessage() {
        getWait().forVisibility(emptyAlertMessage);
        assertTrue(emptyAlertMessage.isDisplayed());
    }
    public void waitForLoadingLoginPageURL() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://test-dev.coconutbox.com/login/"));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void login(String email, String password) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(emailInputField));
            emailInputField.sendKeys(email);
            wait.until(ExpectedConditions.visibilityOf(passwordInputField));
            passwordInputField.sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //div[@class='alert-box-title']

    public void waitForLoadingLoginPage() {
        getWait().forVisibility(emailInputField);
        assertTrue(emailInputField.isDisplayed());
    }


}