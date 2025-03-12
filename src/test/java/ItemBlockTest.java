import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemBlockTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;
    ArchivePage archivePage;
    DeletePage deletePage;
    BlockPage blockPage;
    ProtokollPage protokollPage;


    @Test
    public void blockOneItemTest() throws InterruptedException {
        int idOfItem = 13;
        String blockButton = "Sperren";
        String titleName = "Datei sperren";
        String blockReason = "Datei ist veraltet und nicht mehr aktuell";
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
        itemPage.moveToElementAndClick(blockButton);
        blockPage = new BlockPage(driver);
        assertTrue(blockPage.correctTitleName(titleName));
        blockPage.deleteReasonInputField(blockReason);
        blockPage.clickMainBlockButton();
        assertTrue(blockPage.successAlertMessageIsVisible());
        blockPage.clickCloseButton();

    }

    @Test
    public void archiveOneItemTestAndCheckInfoAndProtokoll() throws InterruptedException {
        int idOfItem = 2;
        String blockButton = "Sperren";
        String titleName = "Datei sperren";
        String titleProtokoll = "Protokoll";
        String blockReason = "Datei ist veraltet und nicht mehr aktuell";
        String blockedCategory = "Gesperrt";
        String mainActionInfo = "INFO";
        String mainActionProtokoll = "Protokoll";
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
        itemPage.moveToElementAndClick(blockButton);
        blockPage = new BlockPage(driver);
        assertTrue(blockPage.correctTitleName(titleName));
        blockPage.deleteReasonInputField(blockReason);
        blockPage.clickMainBlockButton();
        assertTrue(blockPage.successAlertMessageIsVisible());
        blockPage.clickCloseButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForAllVisibilityResultItemList();
        mediaListPage.moveToElementAndClick(blockedCategory);
        Thread.sleep(3000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        //Thread.sleep(3000);
        itemPage.moveToElementAndClick(mainActionInfo);
        Thread.sleep(1000);
        assertTrue(itemPage.reasonIsDisplayed(blockReason));
        Thread.sleep(2000);
        itemPage.moveToElementAndClick(mainActionProtokoll);
        protokollPage = new ProtokollPage(driver);
        assertTrue(protokollPage.correctTitleName(titleProtokoll));
        assertTrue(protokollPage.lastActionContainerIsVisible());
        assertTrue(protokollPage.containerContainsLastAction(blockReason));
        Thread.sleep(2000);


    }
}
