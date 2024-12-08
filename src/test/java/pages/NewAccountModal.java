package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

@Slf4j
public class NewAccountModal extends BasePage {

    private final String BUTTON_PATTERN =
            "//button[text()='%s']//ancestor::records-form-footer//ul[@class='slds-button-group-row']";
    private final By SAVE_BUTTON = By.xpath(
            "//button[text()='Save']//ancestor::records-form-footer//ul[@class='slds-button-group-row']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("New Account Modal is not opened");
        }
        return this;
    }

    @Override
    public NewAccountModal open() {
        log.info("New Account Modal is opened");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        return null;
    }

    @Step("Fill New Account form by valid data")
    public NewAccountModal createAccount(Account account) {
        log.info("Creating account '{}' ", account.getAccountName());

        //Account Information
        new Input(driver, "Account Name").write(account.getAccountName());
        if (account.getRatingOption() != null) {
            new Picklist(driver, "Rating").select(account.getRatingOption());
        }
        if (account.getPhone() != null) {
            new Input(driver, "Phone").write(account.getPhone());
        }
        if (account.getFax() != null) {
            new Input(driver, "Fax").write(account.getFax());
        }
        if (account.getAccountNumber() != null) {
            new Input(driver, "Account Number").write(account.getAccountNumber());
        }
        if (account.getWebsite() != null) {
            new Input(driver, "Website").write(account.getWebsite());
        }
//            new Input(driver, "Account Site").write(account.getAccountSite());
//            new Input(driver, "Ticker Symbol").write(account.getTickerSymbol());
//            new Picklist(driver, "Type").select(account.getTypeOption());
//            new Picklist(driver, "Ownership").select(account.getOwnershipOption());
//            new Picklist(driver, "Industry").select(account.getIndustryOption());
//            new Input(driver, "Employees").write(account.getEmployees());
//            new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
//            new Input(driver, "SIC Code").write(account.getSicCode());
//            //Address Information
//            new Textarea(driver, "Billing Street").write(account.getBillingStreet());
//            new Input(driver, "Billing City").write(account.getBillingCity());
//            new Input(driver, "Billing State/Province").write(account.getBillingState());
//            new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZip());
//            new Input(driver, "Billing Country").write(account.getBillingCountry());
//            new Textarea(driver, "Shipping Street").write(account.getShippingStreet());
//            new Input(driver, "Shipping City").write(account.getShippingCity());
//            new Input(driver, "Shipping State/Province").write(account.getShippingState());
//            new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZip());
//            new Input(driver, "Shipping Country").write(account.getShippingCountry());
//            //Additional Information
//            new Input(driver, "SLA Expiration Date").write(account.getSlaExpirationDate());
//            new Picklist(driver, "Customer Priority").select(account.getCustomerPriorityOption());
//            new Picklist(driver, "SLA").select(account.getSlaOption());
//            new Input(driver, "SLA Serial Number").write(account.getSlaSerialNumber());
//            new Picklist(driver, "Upsell Opportunity").select(account.getUpsellOpportunityOption());
//            new Picklist(driver, "Active").select(account.getActiveOption());
//            //Description Information
//            new Textarea(driver, "Description").write(account.getDescription());
        return this;
    }

    @Step("Click on {buttonName} button")
    public AccountsPage clickButton(String buttonName) {
        log.info("Click on '{}' ", buttonName);
        By button = By.xpath(String.format(BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
        return new AccountsPage(driver);
    }
}
