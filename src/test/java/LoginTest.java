import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;

    @Test
    public void positiveLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();

    }
    @Test
    public void negativeLoginTestInvalidPass() {
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, INVALID_PASSWORD);
        loginPage.waitForAlertMessage();

    }
    @Test
    public void negativeLoginTestInvalidEmail()  {
        loginPage = new LoginPage(driver);
        loginPage.login(INVALID_EMAIL, VALID_PASSWORD);
        loginPage.waitForAlertMessage();

    }
    @Test
    public void negativeLoginTestEmptyPass(){
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, EMPTY_PASSWORD);
        loginPage.waitForEmptyAlertMessage();

    }
    @Test
    public void negativeLoginTestEmptyEmail()  {
        loginPage = new LoginPage(driver);
        loginPage.login(EMPTY_EMAIL, VALID_PASSWORD);
        loginPage.waitForEmptyAlertMessage();

    }
    @Test
    public void negativeLoginTestEmptyEmailEmptyPass() {
        loginPage = new LoginPage(driver);
        loginPage.login(EMPTY_EMAIL, EMPTY_PASSWORD);
        loginPage.waitForEmptyAlertMessage();

    }
}