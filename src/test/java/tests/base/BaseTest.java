package tests.base;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import steps.AccountStep;
import steps.ContactStep;
import steps.LoginStep;
import tests.TestListener;
import utils.AllureUtils;


import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected LoginStep loginStep;
    protected AccountStep accountStep;
    protected ContactStep contactStep;
    // protected HomePage homePage;
    protected AccountsPage accountsPage;
//    protected NewAccountModal newAccountModal;
    protected ContactsPage contactsPage;
//    protected NewContactModal newContactModal;


    @Parameters({"browser"})
    @BeforeMethod(description = "Open browser")
    @Description("Open browser")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        accountStep = new AccountStep(driver);
        contactStep = new ContactStep(driver);
        loginStep = new LoginStep(driver);
//        newAccountModal = new NewAccountModal(driver);
//        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
//        contactsPage = new ContactsPage(driver);
//        newContactModal = new NewContactModal(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    @Description("Close browser")
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            AllureUtils.takeScreenshot(driver);
        }
        driver.quit();
    }
}
