import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlockPage extends BasePage {

    public BlockPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement titleName;
    @FindBy(xpath = "//span[contains(text(),'Sperren')]")
    private WebElement mainBlockItemButton;
    @FindBy(xpath = "//div[@class='modal-hint-wrapper animate-slide-left-to-right']//div[@class='alert-box-right']")
    private WebElement successAllertText;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Schließen')]")
    private WebElement closeButton;
    @FindBy(xpath = "//div[@class='input-group']//textarea")
    private WebElement reasonInput;

    public void clickOneItemOfList(int index) {
        //String xpath = "//div[@class='media-item' and @data-id='" + index + "']//*[@class=\"btn-std btn-secondary btn-icon-only btn-medium float-right v-popper--has-tooltip\"]";
        String xpath = "//div[contains(@class, 'media-item') and @data-id='" + index + "']//button[contains(@class, 'btn-std')][last()]";
        moveMouseToTheElement(driver.findElement(By.xpath(xpath)));
        getWait().forClickable(driver.findElement(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();

    }
    public void deleteReasonInputField(String reason) {
        getWait().forVisibility(reasonInput);
        reasonInput.sendKeys(reason);
    }
    public boolean successAlertMessageIsVisible() {
        getWait().forVisibility(successAllertText);
        return successAllertText.isDisplayed();
    }

    public void clickMainBlockButton() {
        getWait().forVisibility(mainBlockItemButton);
        mainBlockItemButton.click();
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
