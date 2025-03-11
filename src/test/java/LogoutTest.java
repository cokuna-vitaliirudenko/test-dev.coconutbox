import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;

    @Test
    public void positiveLoginTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickUserMenuWrapper();
        startPage.clickLogoutButton();
        loginPage.waitForLoadingLoginPageURL();
    }
}
