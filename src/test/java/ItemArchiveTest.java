import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemArchiveTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    ArchivePage archivePage;

    @Test
    public void archiveOneItemTest() throws InterruptedException {
        int idOfItem = 25;
        String archiveButton = "Archivieren";
        //String deleteButton = "Löschen";
        String titleName = "Datei archivieren";
        String archiveReason = "Datei ist veraltet und nicht mehr aktuell";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        //Thread.sleep(1000);
        mediaListPage.waitForAllVisibilityResultItemList();
        //Thread.sleep(2000);
        mediaListPage.clickOneItemOfList(idOfItem);
        //Thread.sleep(2000);
        itemPage = new ItemPage(driver);
        // Thread.sleep(2000);
        itemPage.moveToElementAndClick(archiveButton);
        archivePage = new ArchivePage(driver);
        archivePage.correctTitleName(titleName);
        archivePage.archiveReasonInputField(archiveReason);
        archivePage.clickMainArchiveButton();
        assertTrue(archivePage.successAlertMessageIsVisible());
        archivePage.clickCloseButton();
    }

    @Test
    public void archiveOneItemTestAndCheckInfo() throws InterruptedException {
        int idOfItem = 16;
        String archiveButton = "Archivieren";
        String titleName = "Datei archivieren";
        String archiveReason = "Datei ist veraltet und nicht mehr aktuell";
        String archivedCategory = "Archiviert";
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
        itemPage.moveToElementAndClick(archiveButton);
        archivePage = new ArchivePage(driver);
        archivePage.correctTitleName(titleName);
        archivePage.archiveReasonInputField(archiveReason);
        archivePage.clickMainArchiveButton();
        assertTrue(archivePage.successAlertMessageIsVisible());
        archivePage.clickCloseButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForAllVisibilityResultItemList();
        mediaListPage.moveToElementAndClick(archivedCategory);
        Thread.sleep(1000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        Thread.sleep(1000);
        itemPage.moveToElementAndClick(mainAction);
        assertTrue(itemPage.reasonIsDisplayed(archiveReason));
    }


}
