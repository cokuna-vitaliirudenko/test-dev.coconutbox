import org.junit.jupiter.api.Test;

public class Add20ItemTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    CreateItemPage createItemPage;

    @Test
    public void add20ItemTest() throws InterruptedException {
        String title = "New added item";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
        for (int i = 0; i < 10; i++) {
            mediaListPage.clickAddItemButton();
            mediaListPage.clickCreateItemButton();
            createItemPage = new CreateItemPage(driver);
            createItemPage.titleInputField(title);
            createItemPage.clickSubmitButton();
            createItemPage.uploadImageForCreatingPost();
            createItemPage.clickUploadButton();
            createItemPage.clickCloseButton();
        }
    }
}
