package tests;

import com.github.javafaker.Faker;
import dto.Contact;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static dto.ContactFactory.getContact;

public class ContactsTest extends BaseTest {

    Faker faker = new Faker();

    Contact contact = getContact("Ms.", "15.12.1989", "Web", "Primary");

    Contact contact2 = Contact.builder()
            .phone(faker.phoneNumber().phoneNumber())
            .salutationOption("Ms.")
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .build();

    @Test(testName = "Create a new contact", description = "Check that a new contact can be created")
    @Description("Create a new contact with valid data")
    public void createNewContact() {
        loginStep.login();
        contactStep.create(contact2);
        Assert.assertTrue(contactsPage.isContactCreated(), "Contact is NOT created");
    }
}
