import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestorePage extends BasePage {

    public RestorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement titleName;
    @FindBy(xpath = "//span[contains(text(),'Wiederherstellen')]")
    private WebElement mainRestoreItemButton;
    @FindBy(xpath = "//div[@class='modal-hint-wrapper animate-slide-left-to-right']//div[@class='alert-box-right']")
    private WebElement successAllertText;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Schließen')]")
    private WebElement closeButton;



    public boolean successAlertMessageIsVisible() {
        getWait().forVisibility(successAllertText);
        return successAllertText.isDisplayed();
    }

    public void clickMainRestoreButton() {
        getWait().forVisibility(mainRestoreItemButton);
        mainRestoreItemButton.click();
    }

    public boolean correctTitleName(String name) {
        getWait().forVisibility(titleName);
        return titleName.getText().contains(name);
    }

    public void clickCloseButton() {
        getWait().forVisibility(closeButton);
        closeButton.click();
    }

}
