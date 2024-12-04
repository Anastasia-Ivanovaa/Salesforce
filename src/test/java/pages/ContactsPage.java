package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage{
    private String ACTION_BUTTON_PATTERN =
            "//lightning-button//ancestor::runtime_pipeline_inspector-actions-button-group//button[text()='%s']";
    private final By MESSAGE = By.xpath("//div[@data-aura-class='forceToastMessage']");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Name']")));
        return this;
    }

    @Override
    public ContactsPage open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/pipelineInspection");
        return this;
    }

    @Step("Click on {buttonName} button")
    public NewContactModal clickOnActionButton(String buttonName) {
        By button = By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
        return new NewContactModal(driver);
    }

    public boolean isContactCreated() {
        WebElement messageBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
        String result = messageBlock.getAttribute("data-key");
        return (result.equals("success"));
    }
}
