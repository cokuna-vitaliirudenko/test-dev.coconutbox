import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemDeleteTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    DeletePage deletePage;

    @Test
    public void deleteOneItemTest() throws InterruptedException {
        int idOfItem = 24;
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
        deletePage = new DeletePage(driver);
        deletePage.clickMainDeleteButton();
        assertTrue(deletePage.successAlertMessageIsVisible());
        deletePage.clickCloseButton();

    }

    @Test
    public void archiveOneItemTestAndCheckInfo() throws InterruptedException {
        int idOfItem = 5;
        String deleteButton = "Löschen";
        String titleName = "Datei löschen";
        String deleteReason = "Datei ist veraltet und nicht mehr aktuell";
        String deletedCategory = "Gelöscht";
        String mainAction = "INFO";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
        Thread.sleep(1000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        itemPage.moveToElementAndClick(deleteButton);
        deletePage = new DeletePage(driver);
        deletePage.correctTitleName(titleName);
        deletePage.deleteReasonInputField(deleteReason);
        deletePage.clickMainDeleteButton();
        assertTrue(deletePage.successAlertMessageIsVisible());
        deletePage.clickCloseButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForAllVisibilityResultItemList();
        mediaListPage.moveToElementAndClick(deletedCategory);
        Thread.sleep(1000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        //Thread.sleep(3000);
        itemPage.moveToElementAndClick(mainAction);
        Thread.sleep(1000);
        assertTrue(itemPage.reasonIsDisplayed(deleteReason));
    }
}
