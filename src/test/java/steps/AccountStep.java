package steps;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.AccountsPage;
import pages.HomePage;
import pages.NewAccountModal;

@Log4j2
public class AccountStep {

    HomePage homePage;
    AccountsPage accountsPage;
    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        newAccountModal = new NewAccountModal(driver);
    }

    public void create(Account account) {
        log.info("Create a new account");
        homePage.open()
                .isPageOpened()
                .selectMenuOption("Accounts", AccountsPage.class)
                .clickOnActionButton("New")
                .createAccount(account)
                .clickButton("Save");
    }
}
