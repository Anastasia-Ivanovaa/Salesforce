package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {

    private String ACTION_BUTTON_PATTERN = "//div[@title='%s']";
    private final By MESSAGE = By.xpath("//div[@data-aura-class='forceToastMessage']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Account Name']")));
        return this;
    }

    @Override
    public AccountsPage open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=AllAccounts");
        return this;
    }

    @Step("Click on {buttonName} button")
    public NewAccountModal clickOnActionButton(String buttonName) {
        By button = By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
        return new NewAccountModal(driver);
    }

    public boolean isAccountCreated() {
        WebElement messageBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
        String result = messageBlock.getAttribute("data-key");
        return (result.equals("success"));
    }
}
