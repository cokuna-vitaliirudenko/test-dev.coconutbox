import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanRestoreBlokedItem extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    UnBlockPage unBlockPage;

    @Test
    public void restoreOneArchivedItemTest() throws InterruptedException {
        int idOfItem = 1;
        String mainAction = "ENTSPERREN";
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
        Thread.sleep(2000);
        mediaListPage.moveToElementAndClick(blockedCategory);
        Thread.sleep(2000);
        mediaListPage.clickOneItemOfList(idOfItem);
        //Thread.sleep(2000);
        itemPage = new ItemPage(driver);
        // Thread.sleep(2000);
        itemPage.moveToElementAndClick(mainAction);
        Thread.sleep(2000);
        unBlockPage = new UnBlockPage(driver);
        unBlockPage.correctTitleName(titleName);
        unBlockPage.clickMainUnBlockButton();
        assertTrue(unBlockPage.successAlertMessageIsVisible());
        unBlockPage.clickCloseButton();
    }
}
