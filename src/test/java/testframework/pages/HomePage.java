package testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class HomePage extends BasePage {

    final By popularMakeLabel = By.xpath("//h2[text() = 'Popular Make']");

    public HomePage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }

    public boolean isInHomePage() {
        return elementIsDisplayed(popularMakeLabel);
    }
}
