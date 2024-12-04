package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this.driver);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    @Override
    public BasePage open() {
        return null;
    }

    @FindBy(id = "userName")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBys({
            @FindBy(id = "Login"), @FindBy(id = "test")
    })
    WebElement loginButton;

    public void ope() {
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com/");
    }

    public void login(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
