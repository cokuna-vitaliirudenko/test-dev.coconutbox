import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanRestoreAllBlockedItemsTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    RestorePage restorePage;
    UnBlockPage unBlockPage;

    @Test
    public void restoreAllArchivedItemsTest() throws InterruptedException {
        String unblockButton = "ENTSPERREN";
        String titleName = "Datei entsperren";
        String blockedCategory = "Gesperrt";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
        Thread.sleep(1000);
        mediaListPage.moveToElementAndClick(blockedCategory);
        for (int i = 0; i < 20; i++) {
            List<WebElement> blockedItems = mediaListPage.getBlockedItems();
            if (blockedItems.isEmpty()) {
                break;
            }
            WebElement item = blockedItems.get(0);
            Actions actions = new Actions(driver);
            actions.moveToElement(item).perform();
            item.click();
            itemPage = new ItemPage(driver);
            Thread.sleep(1000);
            itemPage.moveToElementAndClick(unblockButton);
            unBlockPage = new UnBlockPage(driver);
            assertTrue(unBlockPage.correctTitleName(titleName));
            unBlockPage.clickMainUnBlockButton();
            assertTrue(unBlockPage.successAlertMessageIsVisible());
            unBlockPage.clickCloseButton();
            mediaListPage = new MediaListPage(driver);
            mediaListPage.waitForLoadingItemsListPage();
            mediaListPage.moveToElementAndClick(blockedCategory);
        }
    }
}
