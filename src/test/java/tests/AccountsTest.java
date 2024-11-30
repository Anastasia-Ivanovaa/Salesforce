package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AccountsTest extends BaseTest {

    @Test
    public void checkCreateAccount() {
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("tborodich@tms.sandbox");
        driver.findElement(By.id("password")).sendKeys("Password001");
        driver.findElement(By.id("Login")).click();
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        driver.findElement(By.xpath("//div[@title ='New']")).click();
        newAccountModal.createAccount("TMS", "123456", "147852", "Belskogo", "Warm");

        driver.findElement(By.xpath("//*[@name='Name']")).sendKeys("TeachMeSkills");
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
    }
}
