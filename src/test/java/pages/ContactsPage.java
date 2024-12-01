package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage{
    private String ACTION_BUTTON_PATTERN =
            "//lightning-button//ancestor::runtime_pipeline_inspector-actions-button-group//button[text()='%s']";

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on {buttonName} button")
    public void clickOnActionButton(String buttonName) {
        By button = By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
    }
}
