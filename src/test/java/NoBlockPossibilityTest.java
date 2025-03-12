import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NoBlockPossibilityTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;

    @Test
    public void noBlockPossibilityTest() throws InterruptedException {
        int idOfItem = 1;
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL_KIRSTEN, VALID_PASSWORD_KIRSTEN);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
        Thread.sleep(2000);
        mediaListPage.clickOneItemOfList(idOfItem);
        itemPage = new ItemPage(driver);
        Thread.sleep(1000);
       assertFalse(itemPage.blockButtonIsVisible());

    }

}
