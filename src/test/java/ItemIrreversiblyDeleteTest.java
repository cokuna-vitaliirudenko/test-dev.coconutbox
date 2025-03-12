import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemIrreversiblyDeleteTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;

    @Test
    public void irreversiblyDeleteOneItemTest() throws InterruptedException {
        int idOfItem = 4;
        String deletedCategory = "Gelöscht";
        String deleteButton = "Löschen";
        String titleName = "Datei löschen";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
        Thread.sleep(2000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        itemPage.correctTitleName(titleName);
        itemPage.moveToElementAndClick(deleteButton);
        itemPage.clickMainDeleteButton();
        assertTrue(itemPage.successAlertMessageIsVisible());
        itemPage.clickCloseButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.moveToElementAndClick(deletedCategory);
        //mediaListPage.waitForAllVisibilityResultItemList();
        Thread.sleep(2000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        itemPage.clickMainDeleteButton();
        assertTrue(itemPage.successAlertMessageIsVisible());
        itemPage.clickCloseButton();
    }
}
