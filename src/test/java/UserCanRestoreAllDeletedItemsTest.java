import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanRestoreAllDeletedItemsTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    RestorePage restorePage;

    @Test
    public void restoreAllDeletedItemsTest() throws InterruptedException {
        String restoreButton = "WIEDERHERSTELLEN";
        String titleName = "Datei wiederherstellen";
        String deletedCategory = "Gelöscht";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
        Thread.sleep(1000);
        mediaListPage.moveToElementAndClick(deletedCategory);
        //Thread.sleep(1000);
        for (int i = 0; i < 20; i++) {
            List<WebElement> deletedItems = mediaListPage.getDeletedItems();
            if (deletedItems.isEmpty()) {
                break;
            }
            WebElement item = deletedItems.get(0);
            Actions actions = new Actions(driver);
            actions.moveToElement(item).perform();
            item.click();
            itemPage = new ItemPage(driver);
            itemPage.moveToElementAndClick(restoreButton);
            restorePage = new RestorePage(driver);
            restorePage.correctTitleName(titleName);
            restorePage.clickMainRestoreButton();
            assertTrue(restorePage.successAlertMessageIsVisible());
            restorePage.clickCloseButton();
            mediaListPage.waitForLoadingItemsListPage();
            mediaListPage.moveToElementAndClick(deletedCategory);
            //Thread.sleep(1000);
        }
    }
}
