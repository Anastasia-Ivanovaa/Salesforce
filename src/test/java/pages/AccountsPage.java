package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AccountsPage extends BasePage {

    private String ACTION_BUTTON_PATTERN = "//div[@title='%s']";
    private final By MESSAGE = By.xpath("//div[@data-aura-class='forceToastMessage']");
    private final By ACCOUNT_NAME_BUTTON = (By.xpath("//span[@title='Account Name']"));

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_NAME_BUTTON));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            Assert.fail("Accounts page is not opened");
        }
        return this;
    }

    @Override
    public AccountsPage open() {
        log.info("Accounts page is opened");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=AllAccounts");
        return this;
    }

    @Step("Click on {buttonName} button")
    public NewAccountModal clickOnActionButton(String buttonName) {
        log.info("Click on '{}' button", buttonName);
        By button = By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
        return new NewAccountModal(driver);
    }

    public boolean isAccountCreated() {
        log.info("Account is created");
        WebElement messageBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
        String result = messageBlock.getAttribute("data-key");
        return (result.equals("success"));
    }
}
