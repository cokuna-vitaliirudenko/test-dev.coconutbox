import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanRestoreAllArchivedItemsTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    RestorePage restorePage;

    @Test
    public void restoreAllArchivedItemsTest() throws InterruptedException {
        String restoreButton = "Wiederherstellen";
        String titleName = "Datei wiederherstellen";
        String archivedCategory = "Archiviert";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
        Thread.sleep(1000);
        mediaListPage.moveToElementAndClick(archivedCategory);
        //Thread.sleep(1000);
        for (int i = 0; i < 20; i++) {
            List<WebElement> archivedItems = mediaListPage.getArchivedItems();
            if (archivedItems.isEmpty()) {
                break;
            }
            WebElement item = archivedItems.get(0);
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
            mediaListPage.moveToElementAndClick(archivedCategory);
           // Thread.sleep(1000);
        }
    }
}
