import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MediaListPage extends BasePage {

    public MediaListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='moduleName']")
    private WebElement categoryTitle;

    @FindBy(xpath = "//button[@id='handleAddButton']")
    private WebElement addItemButton;

    @FindBy(xpath = "//div[@class='media-item' and @data-id='8']")
    private WebElement itemFromList;

    @FindBy(xpath = "//*[@class='media-item']")
    private List<WebElement> resultItemList;

    @FindBy(xpath = "//*[@class='media-item'][7]")
    private WebElement sevenItem;

    //*[@class="btn-std btn-secondary btn-icon-only btn-medium float-right"]
    @FindBy(xpath = "//*[@class='btn-std btn-secondary btn-icon-only btn-medium float-right']")
    private WebElement oneItemBearbeiten;
    @FindBy(xpath = "//div[@class='media-item' and @data-id='2']//*[@class='btn-std btn-secondary btn-icon-only btn-medium float-right']")
    private WebElement oneItemBearbeitenTwo;

    @FindBy(xpath = "//button[normalize-space()='Erstellen']")
    private WebElement createItemButton;

    public void clickCreateItemButton() {
        getWait().forClickable(createItemButton);
        createItemButton.click();
    }

    public void clickSevenItem() {
        getWait().forClickable(sevenItem);
        sevenItem.click();
    }



    @FindBy(xpath = "//*[@class='dropdown-menu-container content-navbar-container view']")
    private WebElement gridViewButton;

    @FindBy(xpath = "//*[@class='navbar-area-item']")
    private List<WebElement> sideMenuButtons;

    public void clickOneItemOfList(int index) {
        //String xpath = "//div[@class='media-item' and @data-id='" + index + "']//*[@class='btn-std btn-secondary btn-icon-only btn-medium float-right v-popper--has-tooltip']";
        String xpath = "//div[contains(@class, 'media-item') and @data-id='" + index + "']//button[contains(@class, 'btn-std')][last()]";
        //getWait().forVisibility(driver.findElement(By.xpath(xpath)));
        moveMouseToTheElement(driver.findElement(By.xpath(xpath)));
        getWait().forClickable(driver.findElement(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();

    }

    public List<WebElement> getDeletedItems() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'media-item') and @data-id]//button[contains(@class, 'btn-std')][last()]")));
        List<WebElement> deletedItems = driver.findElements(By.xpath("//div[contains(@class, 'media-item') and @data-id]//button[contains(@class, 'btn-std')][last()]"));
        return deletedItems;
    }
    public List<WebElement> getArchivedItems() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'media-item') and @data-id]//button[contains(@class, 'btn-std')][last()]")));
        List<WebElement> archivedItems = driver.findElements(By.xpath("//div[contains(@class, 'media-item') and @data-id]//button[contains(@class, 'btn-std')][last()]"));
        return archivedItems;
    }

    public void moveToElementAndClick(String name) {
        super.moveToElementAndClick(name, sideMenuButtons);
    }

    public void clickAddItemButton() {
        getWait().forVisibility(addItemButton);
        addItemButton.click();
    }

    public void chooseGridView() {
        getWait().forVisibility(gridViewButton);
        gridViewButton.click();
    }

    public void waitForLoadingItemsListPage() {
        getWait().forVisibility(categoryTitle);
        assertTrue(categoryTitle.isDisplayed());
    }

    public void clickOneItemOfListTwo() {
        getWait().forVisibility(itemFromList);
        itemFromList.click();
    }


    public void waitForAllVisibilityResultItemList() {
        getWait().forAllVisibility(resultItemList);
        System.out.println(resultItemList.size());
    }


}
