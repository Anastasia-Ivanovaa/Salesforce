package pages;


import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewAccountModal extends BasePage {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void createAccount(String name, String phone, String fax, String street, String option) {
        new Input(driver, "Account Name").write(name);
        new Picklist(driver, "Rating").select(option);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Textarea(driver, "Billing Street").write(street);
    }
}
