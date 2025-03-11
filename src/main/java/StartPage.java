import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    // @FindBy(xpath = "(//a[@href='/media/'])[1]")
    @FindBy(xpath = "//*[@class='nav-item']//a[@href='/media/']")
    private WebElement mediaButton;
    @FindBy(id = "userMenuWrapper")
    private WebElement userMenuButton;
    @FindBy(xpath = "//button[normalize-space()='Abmelden']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[normalize-space()='Mein Profil']")
    private WebElement myProfileButton;


    @FindBy(xpath = "//*[@class='nav-item']//a[@href='/media/']")
    private WebElement modulMediaButton;

    public void clickModulMediaButton() {
        getWait().forClickable(modulMediaButton);
        modulMediaButton.click();
    }

    public void clickMyProfileButton() {
        getWait().forClickable(myProfileButton);
        myProfileButton.click();
    }

    public void clickLogoutButton() {
        getWait().forClickable(logoutButton);
        logoutButton.click();
    }

    public void clickUserMenuWrapper() {
        getWait().forClickable(userMenuButton);
        userMenuButton.click();
    }

    public void clickMediaButton() {
        getWait().forClickable(mediaButton);
        mediaButton.click();
    }


    public void waitForLoadingStartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://test-dev.coconutbox.com/home/"));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

//    public void moveToElementAndClick(String name) {
//        List<WebElement> elements = categoryGridItemsName;
//        getWait().forAllVisibility(elements);
//        for (WebElement element : elements) {
//            if (element.getText().contains(name)) {
//                Actions actions = new Actions(driver);
//                actions.moveToElement(element).click().perform();
//                break;
//            }
//        }
//    }

}