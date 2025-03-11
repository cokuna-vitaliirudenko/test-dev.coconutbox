import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanRestoreArchivedItem extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    RestorePage restorePage;

    @Test
    public void restoreOneArchivedItemTest() throws InterruptedException {
        int idOfItem = 26;
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
        Thread.sleep(2000);
        mediaListPage.moveToElementAndClick(archivedCategory);
        Thread.sleep(2000);
        mediaListPage.clickOneItemOfList(idOfItem);
        //Thread.sleep(2000);
        itemPage = new ItemPage(driver);
        // Thread.sleep(2000);
        itemPage.moveToElementAndClick(restoreButton);
        Thread.sleep(2000);
        restorePage = new RestorePage(driver);
        restorePage.correctTitleName(titleName);
        restorePage.clickMainRestoreButton();
        assertTrue(restorePage.successAlertMessageIsVisible());
        restorePage.clickCloseButton();
    }
}
