import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class ItemPage extends BasePage {

    @FindBy(xpath = " //div[@class='favouritesWrapper show-for-large']//span//*[name()='svg']//*[name()='path' and contains(@d,'M21.317,3.')]")
    private WebElement addToFavoriteButton;
    @FindBy(xpath = " //*[@data-testid='price-alert-button']")
    private WebElement priceAlertButton;
    @FindBy(xpath = "//li[9]")
    private WebElement deleteItemButton;
    //span[contains(text(),'Löschen')]
    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    private WebElement mainDeleteItemButton;
    @FindBy(xpath = "//h1")
    private WebElement titleName;
    @FindBy(xpath = "//*[@class='popup-sidebar']//li")
    private List<WebElement> activeButtonList;
    @FindBy(xpath = "//div[@class='modal-hint-wrapper animate-slide-left-to-right']//div[@class='alert-box-right']")
    private WebElement successAllertText;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Schließen')]")
    private WebElement closeButton;

    @FindBy(xpath = "//span[normalize-space()='Löschen']")
    private WebElement deleteButton;
    @FindBy(xpath = "//span[normalize-space()='Archivieren']")
    private WebElement archiveButton;
    @FindBy(xpath = "//span[normalize-space()='Sperren']")
    private WebElement blockButton;



    public void clickDelButton() {
        getWait().forVisibility(deleteButton);
        deleteButton.click();
    }
    public boolean blockButtonIsVisible() {
        try {
            return blockButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean archiveButtonIsVisible() {
        try {
            return archiveButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteButtonIsVisible() {
        try {
            return deleteButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean reasonIsDisplayed(String archiveReason) {

        //getWait().forVisibility(driver.findElement(By.xpath("//*[@class='modal-hint-wrapper animate-slide-left-to-right']")));
        // String archiveReasonInfo = "//*[@class='modal-hint-wrapper animate-slide-left-to-right']//div[contains(text(),'" + archiveReason + "')]";
        WebElement reason = driver.findElement(By.xpath("//*[@class='modal-hint-wrapper animate-slide-left-to-right']//div[contains(text(),'" + archiveReason + "')]"));
        getWait().forVisibility(reason);
        return reason.getText().contains(archiveReason);

    }

    public boolean correctTitleName(String name) {
        getWait().forVisibility(titleName);
        return titleName.getText().contains(name);
    }

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void moveToElementAndClick(String name, List<WebElement> webElementsList) {
        super.moveToElementAndClick(name, webElementsList);
    }

    public void moveToElementAndClick(String name) {
        super.moveToElementAndClick(name, activeButtonList);
    }

    public boolean successAlertMessageIsVisible() {
        getWait().forVisibility(successAllertText);
        return successAllertText.isDisplayed();
    }

    public void clickCloseButton() {
        getWait().forVisibility(closeButton);
        closeButton.click();
    }

    public void clickDeleteButton() {
        getWait().forVisibility(deleteItemButton);
        deleteItemButton.click();
    }

    public void clickMainDeleteButton() {
        getWait().forVisibility(mainDeleteItemButton);
        mainDeleteItemButton.click();
    }

    public void clickFavoriteButton() {
        getWait().forVisibility(addToFavoriteButton);
        addToFavoriteButton.click();
    }


    public void clickPriceAlertButton() {
        getWait().forVisibility(priceAlertButton);
        priceAlertButton.click();
    }
}
