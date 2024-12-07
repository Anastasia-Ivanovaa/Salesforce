package tests;


import dto.Account;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static dto.AccountFactory.getAccount;

public class AccountsTest extends BaseTest {

    Account account = getAccount("Hot", "4585522", "Other", "Public",
            "Banking", "100", "1000", "04.12.2024", "High",
            "Silver", "222555", "No", "Yes");

    Account account2 = Account.builder()
            .accountName("Anastasia")
            .accountNumber("333334")
            .fax("443423")
            .build();

    @Test(testName = "Create a new account", description = "Check that a new account can be created")
    @Description("Create a new account with valid data")
    public void checkCreateAccount() {
        loginStep.login();
        accountStep.create(account);
        Assert.assertTrue(accountsPage.isAccountCreated(), "Account is NOT created");
    }
}
