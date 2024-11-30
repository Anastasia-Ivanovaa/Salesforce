package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {

    private String ACTION_BUTTON_PATTERN = "//div[@title='%s']";

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on {buttonName} button")
    public void clickOnActionButton(String buttonName) {
        By button = By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
    }


}
