package steps;

import dto.Contact;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.*;

@Log4j2
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
        log.info("Create a new contact");
        homePage.open()
                .selectMenuOption("Contacts", ContactsPage.class)
                .clickOnActionButton("New")
                .createContact(contact)
                .clickButton("Save");
    }
}
