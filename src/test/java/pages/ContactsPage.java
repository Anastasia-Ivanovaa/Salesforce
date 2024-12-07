package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2

public class ContactsPage extends BasePage {
    private String ACTION_BUTTON_PATTERN =
            "//lightning-button//ancestor::runtime_pipeline_inspector-actions-button-group//button[text()='%s']";
    private final By MESSAGE = By.xpath("//div[@data-aura-class='forceToastMessage']");
    private final By NAME_COLUMN = By.xpath("//span[@title='Name']");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_COLUMN));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Contact page is not opened");
        }
        return this;
    }

    @Override
    public ContactsPage open() {
        log.info("Contacts page is opened");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/pipelineInspection");
        return this;
    }

    @Step("Click on {buttonName} button")
    public NewContactModal clickOnActionButton(String buttonName) {
        log.info("Click on '{}' button", buttonName);
        By button = By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
        return new NewContactModal(driver);
    }

    public boolean isContactCreated() {
        log.info("Contact is created");
        WebElement messageBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
        String result = messageBlock.getAttribute("data-key");
        return (result.equals("success"));
    }
}
