import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Wait getWait() {
        return new Wait(driver);
    }
    public void moveMouseToTheElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void moveToElementAndClick(String name, List<WebElement> webElementsList) {
        List<WebElement> elements = webElementsList;
        getWait().forAllVisibility(elements);
        for (WebElement element : elements) {
            getWait().forVisibility(element);
            if (element.getText().contains(name)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().perform();
                break;
            }
        }
    }
    public void selectWith(WebElement element, String text){
        WebElement dropdown = element;
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

}