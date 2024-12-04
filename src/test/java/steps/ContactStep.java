package steps;

import dto.Account;
import dto.Contact;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ContactStep {

    HomePage homePage;
    ContactsPage contactsPage;
    NewContactModal newContactModal;

    public ContactStep(WebDriver driver) {
        homePage = new HomePage(driver);
        contactsPage = new ContactsPage(driver);
        newContactModal = new NewContactModal(driver);
    }


    public void create(Contact contact) {
        homePage.open()
                .selectMenuOption("Contacts", ContactsPage.class)
                .clickOnActionButton("New")
                .createContact(contact)
                .clickButton("Save");
    }
}
