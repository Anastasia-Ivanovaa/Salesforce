package tests;


import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AccountsTest extends BaseTest {

    @Test(testName = "Create a new account", description = "Check that a new account can be created")
    @Description("Create a new account with valid data")
    public void checkCreateAccount() {
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password001");
        homePage.open();
        homePage.selectMenuOption("Accounts");
        accountsPage.clickOnActionButton("New");
        newAccountModal.createAccount("Test 4", "123-44-55", "23444", "Street1", "Warm");
        newAccountModal.clickButton("Save");
    }
}
