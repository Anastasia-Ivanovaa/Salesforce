package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewAccountModal extends BasePage {

    private final String BUTTON_PATTERN = "//button[text()='%s']//ancestor::records-form-footer//ul[@class='slds-button-group-ro']";

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Fill New Account form by valid data")
    public void createAccount(String name, String phone, String fax, String street, String option) {
        new Input(driver, "Account Name").write(name);
        new Picklist(driver, "Rating").select(option);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Textarea(driver, "Billing Street").write(street);

    }

    @Step("Click on {buttonName} button")
    public void clickButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
    }
}
