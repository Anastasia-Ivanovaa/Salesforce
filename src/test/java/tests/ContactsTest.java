package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ContactsTest extends BaseTest {

    @Test(testName = "Create a new contact", description = "Check that a new contact can be created")
    @Description("Create a new contact with valid data")
    public void createNewContact(){
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password001");
        homePage.open();
        homePage.selectMenuOption("Contacts");
        contactsPage.clickOnActionButton("New");
        newContactModal.createContact("258-855-96", "258-963-66","Mrs.","Ann",
                "Smith", "258-963-69", "testTitle", "147-852-33", "QA",
                "225-55-636", "01.01.2001", "test@gmail.com", "Bob Smith", "Purchased List",
                "1114-252-33", "High Street 5", "New York", "New York",
                "258963", "USA", "Other Street 4","New Jersey",
                "MO", "114526","UK", "English","Secondary",
                "Test new Contact");
        newContactModal.clickButton("Save");
    }
}
