import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProtokollPage extends BasePage {
    public ProtokollPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement titleName;
    @FindBy(xpath = "//*[@class='form-row changelog-row'][position()=1]")
    private WebElement lastActionContainer;


    public boolean lastActionContainerIsVisible() {
        getWait().forVisibility(lastActionContainer);
        return lastActionContainer.isDisplayed();
    }
    public boolean correctTitleName(String name) {
        getWait().forVisibility(titleName);
        return titleName.getText().contains(name);
    }
    public boolean containerContainsLastAction(String name) {
        getWait().forVisibility(lastActionContainer);
        return lastActionContainer.getText().contains(name);
    }

}

