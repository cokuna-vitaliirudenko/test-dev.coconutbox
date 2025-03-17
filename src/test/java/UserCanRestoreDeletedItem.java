import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanRestoreDeletedItem extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    RestorePage restorePage;

    @Test
    public void restoreOneItemTest() throws InterruptedException {
        int idOfItem = 8;
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
        Thread.sleep(2000);
        mediaListPage.moveToElementAndClick(deletedCategory);
        Thread.sleep(2000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        // Thread.sleep(2000);
        itemPage.moveToElementAndClick(restoreButton);
        restorePage = new RestorePage(driver);
        restorePage.correctTitleName(titleName);
        restorePage.clickMainRestoreButton();
        assertTrue(restorePage.successAlertMessageIsVisible());
        restorePage.clickCloseButton();
    }
}
