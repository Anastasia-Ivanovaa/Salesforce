package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class HomePage extends BasePage {

    private final String MENU_OPTION_PATTERN = "//span[text()='%s']//ancestor::one-app-nav-bar-item-root[@role='listitem']";
    private final By USER_BUTTON = By.xpath("//img[@alt='User']//ancestor::button[@type='button']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage isPageOpened() {
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_BUTTON));}
        catch (TimeoutException e){
            log.error(e.getMessage());
            Assert.fail("Homepage is NOT opened");
        }
        return this;
    }

    @Step("Open Home page")
    public HomePage open() {
        log.info("Home page is opened");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/page/home");
        return this;
    }

    @Step("Select option {optionName} in the menu bar")
    public <T extends BasePage> T selectMenuOption(String optionName, Class<T> pageClass) {
        log.info("Select menu option '{}'", optionName);
        By setOption = By.xpath(String.format(MENU_OPTION_PATTERN, optionName));
        driver.findElement(setOption).click();
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
