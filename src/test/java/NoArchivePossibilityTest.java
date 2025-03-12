import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NoArchivePossibilityTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;

    @Test
    public void noArchivePossibilityTest() throws InterruptedException {
        int idOfItem = 1;
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL_SAMMUEL, VALID_PASSWORD_SAMMUEL);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
        Thread.sleep(2000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        Thread.sleep(3000);
        assertFalse(itemPage.archiveButtonIsVisible());


    }

}
