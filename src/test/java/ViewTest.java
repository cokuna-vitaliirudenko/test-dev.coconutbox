import org.junit.jupiter.api.Test;

public class ViewTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;

    @Test
    public void positiveLoginTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickMediaButton();
    }

    @Test
    public void chooseOneItemFromCategoryAndAddToFavorite() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        Thread.sleep(5000);
        mediaListPage.waitForAllVisibilityResultItemList();
        //mediaListPage.chooseGridView();
        mediaListPage.clickSevenItem();
        Thread.sleep(3000);

    }
}
