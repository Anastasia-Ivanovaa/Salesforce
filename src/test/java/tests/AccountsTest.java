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
        newAccountModal.createAccount(
                "Test 8", "Hot", "23444", "14-85-555", "147852",
                "test.com", "account.com", "ACNT", "Other", "Public",
                "Banking", "10", "1000", "2525", "Street 5th",
                "Connecticut", "New York", "06001", "USA", "Street 21st",
                "Birmingham", "Alabama", "35005", "USA",
                "Medium", "Gold", "01.12.2024", "369852KL",
                "50", "No", "Yes", "New test account");
        newAccountModal.clickButton("Save");
    }
}
