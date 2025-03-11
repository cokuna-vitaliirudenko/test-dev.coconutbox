import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyProfileEditTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    MyProfilePage myProfilePage;
    PersonalDataPage personalDataPage;


    @Test
    public void userCanEditMainSettings() throws InterruptedException {
        String titleName = "Persönliche Daten verwalten";
        String anrede = "Frau";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickUserMenuWrapper();
        startPage.clickMyProfileButton();
        myProfilePage = new MyProfilePage(driver);
        myProfilePage.waitForMyProfileTitleVisibility();
        myProfilePage.clickMyProfileMainSettingsButton();
        personalDataPage = new PersonalDataPage(driver);
        assertTrue(personalDataPage.correctTitleName(titleName));
        personalDataPage.clickAnredeButton();
        personalDataPage.clickAnredeFrauButton();
        Thread.sleep(2000);

        myProfilePage.clickMyProfileCloseButton();
    }

    @Test
    public void userCanEditAdvancedSettings() throws InterruptedException {
        String titleName = "Zusätzliche Einstellungen verwalten";
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickUserMenuWrapper();
        startPage.clickMyProfileButton();
        myProfilePage = new MyProfilePage(driver);
        myProfilePage.waitForMyProfileTitleVisibility();
        myProfilePage.clickMyProfileAdvancedSettingsButton();
        personalDataPage = new PersonalDataPage(driver);
        assertTrue(personalDataPage.correctTitleName(titleName));


        myProfilePage.clickMyProfileCloseButton();
    }
}
