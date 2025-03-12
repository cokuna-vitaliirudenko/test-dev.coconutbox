import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoDeletePossibilityTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    ItemPage itemPage;

    @Test
    public void noDeletePossibilityTest() throws InterruptedException {
        int idOfItem = 1;
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL_BALBOA, VALID_PASSWORD_BALBOA);
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
        assertFalse(itemPage.deleteButtonIsVisible());
    }

}
