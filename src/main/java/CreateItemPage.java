import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateItemPage extends BasePage {
    public CreateItemPage(WebDriver driver) {
        super(driver);
    }

    private static final String ABSOLUTEPATHFORCREATING = "/Users/vitaliirudenko/IdeaProjects/cokuna/src/main/resources/Bilder/hugo-boss.jpg";
    @FindBy(xpath = "//input[@placeholder='Title']")
    private WebElement titleInputField;
    @FindBy(xpath = "//*[@placeholder='Description']")
    private WebElement descriptionInputField;
    @FindBy(xpath = "//*[@name='content']")
    private WebElement contentDescriptionInputField;
    @FindBy(xpath = "//*[@name='attr[1][0]']")
    private WebElement titleInput;
    @FindBy(xpath = "//*[@class='input-wrapper focused']")
    private WebElement titleInputFocused;
    @FindBy(xpath = "//span[contains(text(),'Weiter')]")
    private WebElement submitButton;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Hochladen')]")
    private WebElement uploadButton;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Schließen')]")
    private WebElement closeButton;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement imageUploadField;
    @FindBy(xpath = "//*[@data-test='uploaded-image']")
    private WebElement uploadedImage;
    @FindBy(xpath = "//*[@class='qq-upload-button-selector']")
    private WebElement imageContainer;
//*[@class="qq-upload-button-selector"]
    //span[contains(text(),'Weiter')]

    public void titleInputField(String title) {
        getWait().forVisibility(titleInput);
        titleInput.sendKeys(title);
    }


    public void waitForLoadingAllFields() {
        getWait().forVisibility(titleInputField);
        assertTrue(titleInputField.isDisplayed());
        getWait().forVisibility(descriptionInputField);
        assertTrue(descriptionInputField.isDisplayed());
        getWait().forVisibility(contentDescriptionInputField);
        assertTrue(contentDescriptionInputField.isDisplayed());
    }

    public boolean fieldsAreNotVisible() {
        assertFalse(titleInputField.isEnabled());
        assertFalse(descriptionInputField.isEnabled());
        assertFalse(contentDescriptionInputField.isEnabled());
        return true;
    }

    public void waitForLoadingImage() {
        getWait().forVisibility(uploadedImage);
        assertTrue(uploadedImage.isDisplayed());
    }

    public void setTitleInputField(String title) {
        titleInputField.sendKeys(title);
    }

    public void setDescriptionInputField(String description) {
        descriptionInputField.sendKeys(description);
    }

    public void setContentDescriptionInputField(String contentDescription) {
        contentDescriptionInputField.sendKeys(contentDescription);
    }

    public void setPostData(String title, String description, String contentDescription) {
        titleInputField.sendKeys(title);
        descriptionInputField.sendKeys(description);
        contentDescriptionInputField.sendKeys(contentDescription);
    }

//    public void clickOnTheSaveAsDraftSwitcher() {
//        saveAsDraftSwitcher.isDisplayed();
//        saveAsDraftSwitcher.click();
//    }

    public void clickSubmitButton() {
        submitButton.isDisplayed();
        submitButton.click();
    }

    public void clickUploadButton() {
        getWait().forVisibility(uploadButton);
        uploadButton.click();
    }

    public void clickCloseButton() {
        getWait().forVisibility(closeButton);
        closeButton.click();
    }

    public void uploadImageForCreatingPost() {
        getWait().forVisibility(imageContainer);
        imageUploadField.sendKeys(ABSOLUTEPATHFORCREATING);
    }


}
