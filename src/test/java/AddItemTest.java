import org.junit.jupiter.api.Test;

public class AddItemTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MediaListPage mediaListPage;
    CreateItemPage createItemPage;

    @Test
    public void addItemTest() throws InterruptedException {
        String title = "New added item";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickModulMediaButton();
        mediaListPage = new MediaListPage(driver);
        mediaListPage.waitForLoadingItemsListPage();
        mediaListPage.waitForAllVisibilityResultItemList();
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
