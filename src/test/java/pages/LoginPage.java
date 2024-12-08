package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("username");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException a) {
            log.error(a.getMessage());
            Assert.fail("Login page isn't opened");
        }
        return this;
    }

    @Step("Open Login page")
    public LoginPage open() {
        log.info("Login page is opened");
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com/");
        return this;
    }

    @Step("Login into app - username:{userName} password:{password}")
    public HomePage login(String userName, String password) {
        log.info("Log into application using credentials '{}' '{}'", userName, password);
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}
