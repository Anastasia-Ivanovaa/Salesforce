package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@Log4j2
public class LoginStep {

    LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void login() {
        log.info("Login into application");
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password001")
                .open();
    }
}
