package tests;

import dto.Contact;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static dto.ContactFactory.getContact;

public class ContactsTest extends BaseTest {

    Contact contact = getContact("Ms.", "15.12.1989", "Web", "Primary");

    @Test(testName = "Create a new contact", description = "Check that a new contact can be created")
    @Description("Create a new contact with valid data")
    public void createNewContact() {
        loginStep.login();
        contactStep.create(contact);
        Assert.assertTrue(contactsPage.isContactCreated(),"Contact is NOT created");
    }
}
