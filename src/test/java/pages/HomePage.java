package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String MENU_OPTION_PATTERN = "//span[text()='%s']//ancestor::one-app-nav-bar-item-root[@role='listitem']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Home page")
    public void open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/page/home");
    }

//    public void openHamburgerMenu(){
//        driver.findElement(By.xpath("//div[@title ='New']")).click();
//    }

    @Step("Select option {optionName} in the menu bar")
    public void selectMenuOption(String optionName) {
        By setOption = By.xpath(String.format(MENU_OPTION_PATTERN, optionName));
        driver.findElement(setOption).click();
    }
}
