package pages;

import dto.Contact;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewContactModal extends BasePage{

    private final String BUTTON_PATTERN = "//lightning-button/button[text()='%s']";

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewContactModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-button/button[text()='New']")));
        return this;
    }

    @Override
    public NewContactModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/new");
        return this;
    }


    @Step("Fill New Contact form with valid data")
    public NewContactModal createContact(Contact contact){
        //Contact Information
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Home Phone").write(contact.getHomePhone());
        new Picklist(driver,"Salutation").select(contact.getSalutationOption());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Other Phone").write(contact.getOtherPhone());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Fax").write(contact.getFax());
        new Input(driver, "Birthdate").write(contact.getBirthdate());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Assistant").write(contact.getAssistant());
        new Picklist(driver,"Lead Source").select(contact.getLeadSourceOption());
        new Input(driver, "Asst. Phone").write(contact.getAsstPhone());
        //Address Information
        new Textarea(driver, "Mailing Street").write(contact.getMailingStreet());
        new Input(driver, "Mailing City").write(contact.getMailingCity());
        new Input(driver, "Mailing State/Province").write(contact.getMailingState());
        new Input(driver, "Mailing Zip/Postal Code").write(contact.getMailingZip());
        new Input(driver, "Mailing Country").write(contact.getMailingCountry());
        new Textarea(driver, "Other Street").write(contact.getOtherStreet());
        new Input(driver, "Other City").write(contact.getOtherCity());
        new Input(driver, "Other State/Province").write(contact.getOtherState());
        new Input(driver, "Other Zip/Postal Code").write(contact.getOtherZip());
        new Input(driver, "Other Country").write(contact.getOtherCountry());
        //Additional Information
        new Input(driver, "Languages").write(contact.getLanguages());
        new Picklist(driver,"Level").select(contact.getLevelOption());
        //Description Information
        new Textarea(driver, "Description").write(contact.getDescription());
        return this;
    }

    @Step("Click on {buttonName} button")
    public ContactsPage clickButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
        return new ContactsPage(driver);
    }
}
