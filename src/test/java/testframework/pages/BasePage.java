package testframework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickElement(By locator) {
        wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
                return true;
            } catch (StaleElementReferenceException e) {
                System.out.println("Element stale, retrying");
                return false;
            }
        });
    }

    public void enterText(By locator, String value) {
        if (value == null) return;

        wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                element.sendKeys(value);
                return true;
            } catch (StaleElementReferenceException e) {
                System.out.println("Element stale, retrying");
                return false;
            }
        });
    }

    public boolean elementIsDisplayed(By locator) {
        return wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                return element.isDisplayed();
            } catch (StaleElementReferenceException e) {
                System.out.println("Element stale, retrying");
                return false;
            }
        });
    }

    public boolean isElementEnabled(By locator, boolean enabled) {
        return wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                System.out.println(element.isEnabled() == enabled);
                return element.isEnabled() == enabled;
            } catch (StaleElementReferenceException e) {
                System.out.println("Element stale, retrying");
                return false;
            }
        });
    }

    public String getElementText(By locator) {
        return (String) wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                return element.getText();
            } catch (StaleElementReferenceException e) {
                System.out.println("Element stale, retrying");
                return false;
            }
        });
    }

}
