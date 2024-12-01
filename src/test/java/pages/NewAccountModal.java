package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewAccountModal extends BasePage {

    private final String BUTTON_PATTERN =
            "//button[text()='%s']//ancestor::records-form-footer//ul[@class='slds-button-group-row']";

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Fill New Account form by valid data")
    public void createAccount(String accountName, String optionRating, String phone, String fax, String accountNumber,
                              String website, String accountSite, String tickerSymbol, String optionType,
                              String ownershipOption, String industryOption, String employees, String annualRevenue,
                              String sicCode, String billingStreet, String billingCity, String billingState,
                              String billingZip, String billingCountry, String shippingStreet, String shippingCity,
                              String shippingState, String shippingZip, String shippingCountry,
                              String customerPriorityOption, String slaOption, String slaExpirationDate,
                              String slaSerialNumber, String numberOfLocations, String upsellOpportunityOption,
                              String activeOption, String description) {
        //Account Information
        new Input(driver, "Account Name").write(accountName);
        new Picklist(driver, "Rating").select(optionRating);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Account Number").write(accountNumber);
        new Input(driver, "Website").write(website);
        new Input(driver, "Account Site").write(accountSite);
        new Input(driver, "Ticker Symbol").write(tickerSymbol);
        new Picklist(driver, "Type").select(optionType);
        new Picklist(driver, "Ownership").select(ownershipOption);
        new Picklist(driver, "Industry").select(industryOption);
        new Input(driver, "Employees").write(employees);
        new Input(driver, "Annual Revenue").write(annualRevenue);
        new Input(driver, "SIC Code").write(sicCode);
        //Address Information
        new Textarea(driver, "Billing Street").write(billingStreet);
        new Input(driver, "Billing City").write(billingCity);
        new Input(driver, "Billing State/Province").write(billingState);
        new Input(driver, "Billing Zip/Postal Code").write(billingZip);
        new Input(driver, "Billing Country").write(billingCountry);
        new Textarea(driver, "Shipping Street").write(shippingStreet);
        new Input(driver, "Shipping City").write(shippingCity);
        new Input(driver, "Shipping State/Province").write(shippingState);
        new Input(driver, "Shipping Zip/Postal Code").write(shippingZip);
        new Input(driver, "Shipping Country").write(shippingCountry);
        //Additional Information
        new Input(driver, "SLA Expiration Date").write(slaExpirationDate);
        new Picklist(driver, "Customer Priority").select(customerPriorityOption);
        new Picklist(driver, "SLA").select(slaOption);

        new Input(driver, "SLA Serial Number").write(slaSerialNumber);
        new Input(driver, "Number of Locations").write(numberOfLocations);
        new Picklist(driver, "Upsell Opportunity").select(upsellOpportunityOption);
        new Picklist(driver, "Active").select(activeOption);
        //Description Information
        new Textarea(driver, "Description").write(description);
    }

    @Step("Click on {buttonName} button")
    public void clickButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
    }
}
