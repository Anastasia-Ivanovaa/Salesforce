package wrappers;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class Input {

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing '{}' into {}", text, label);
                driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-input//input", label)))
                .sendKeys(text);
    }
}
