package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewContactModal extends BasePage{

    private final String BUTTON_PATTERN = "//lightning-button/button[text()='%s']";

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Step("Fill New Contact form with valid data")
    public void createContact(String phone, String homePhone, String salutationOption, String firstName, String lastName,
                              String mobile, String title, String otherPhone, String department, String fax,
                              String birthdate, String email, String assistant, String leadSourceOption, String asstPhone,
                              String mailingStreet, String mailingCity, String mailingState, String mailingZip,
                              String mailingCountry, String otherStreet, String otherCity, String otherState,
                              String otherZip, String otherCountry, String languages, String levelOption, String description){
        //Contact Information
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Home Phone").write(homePhone);
        new Picklist(driver,"Salutation").select(salutationOption);
        new Input(driver, "First Name").write(firstName);
        new Input(driver, "Last Name").write(lastName);
        new Input(driver, "Mobile").write(mobile);
        new Input(driver, "Title").write(title);
        new Input(driver, "Other Phone").write(otherPhone);
        new Input(driver, "Department").write(department);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Birthdate").write(birthdate);
        new Input(driver, "Email").write(email);
        new Input(driver, "Assistant").write(assistant);
        new Picklist(driver,"Lead Source").select(leadSourceOption);
        new Input(driver, "Asst. Phone").write(asstPhone);
        //Address Information
        new Textarea(driver, "Mailing Street").write(mailingStreet);
        new Input(driver, "Mailing City").write(mailingCity);
        new Input(driver, "Mailing State/Province").write(mailingState);
        new Input(driver, "Mailing Zip/Postal Code").write(mailingZip);
        new Input(driver, "Mailing Country").write(mailingCountry);
        new Textarea(driver, "Other Street").write(otherStreet);
        new Input(driver, "Other City").write(otherCity);
        new Input(driver, "Other State/Province").write(otherState);
        new Input(driver, "Other Zip/Postal Code").write(otherZip);
        new Input(driver, "Other Country").write(otherCountry);
        //Additional Information
        new Input(driver, "Languages").write(languages);
        new Picklist(driver,"Level").select(levelOption);
        //Description Information
        new Textarea(driver, "Description").write(description);
    }

    @Step("Click on {buttonName} button")
    public void clickButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
    }
}
