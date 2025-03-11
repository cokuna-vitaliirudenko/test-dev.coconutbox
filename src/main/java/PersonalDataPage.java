import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PersonalDataPage extends BasePage{
    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement titleName;

    @FindBy(xpath = "//div[@class='multiselect single-select select-input']//div[@class='multiselect__tags']")
    private WebElement anredeButton;

    @FindBy(xpath = "//div[contains(text(),'Frau')]")
    private WebElement anredeFrauButton;

    public void clickAnredeFrauButton() {
        getWait().forClickable(anredeFrauButton);
        anredeFrauButton.click();
    }

    public void clickAnredeButton() {
        getWait().forVisibility(anredeButton);
        anredeButton.click();
    }


    public boolean correctTitleName(String name) {
        getWait().forVisibility(titleName);
        return titleName.getText().contains(name);
    }

}

//h1[@class='popup-title-inner']//span[@class='text-overflow-element'][normalize-space()='Persönliche Daten verwalten']