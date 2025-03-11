
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='table-container table-no-header']//div[2]//div[2]//button[1]")
    private WebElement myProfileAdvancedSettingsButton;
    @FindBy(xpath = "//div[@class='content-view hui']//div[1]//div[2]//button[1]")
    private WebElement myProfileMainSettingsButton;

    @FindBy(xpath = "//*[@class='btn-std btn-primary btn-adaptive btn-onblue float-right']")
    private WebElement myProfileCloseButton;

    @FindBy(xpath = "//div[contains(text(),'Mein Profil')]")
    private WebElement myProfileTitle;

    public void waitForMyProfileTitleVisibility() {
        getWait().forVisibility(myProfileTitle);
        assertTrue(myProfileTitle.isDisplayed());
    }
    public void clickMyProfileCloseButton() {
        getWait().forVisibility(myProfileCloseButton);
        myProfileCloseButton.click();
    }

    public void clickMyProfileAdvancedSettingsButton() {
        getWait().forVisibility(myProfileAdvancedSettingsButton);
        myProfileAdvancedSettingsButton.click();
    }


    public void clickMyProfileMainSettingsButton() {
        getWait().forVisibility(myProfileMainSettingsButton);
        myProfileMainSettingsButton.click();
    }



}