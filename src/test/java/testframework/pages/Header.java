package testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class Header extends BasePage{

    final By brandLnk = By.xpath("//a[text()='Buggy Rating']");
    final By usernameFld = By.name("login");
    final By passwordFld = By.name("password");
    final By loginBtn = By.xpath("//button[text()='Login']");
    final By registerBtn = By.xpath("//a[text()='Register']");
    final By headerMessage = By.xpath("//my-login//span");
    final By logoutBtn = By.xpath("//a[text()='Logout']");

    public Header(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }

    public void clickRegister() {
        clickElement(registerBtn);
    }

    public void enterUsername(String value) {
        enterText(usernameFld, value);
    }

    public void enterPassword(String value) {
        enterText(passwordFld, value);
    }

    public void clickLogin() {
        clickElement(loginBtn);
    }

    public void clickLogout() {
        clickElement(logoutBtn);
    }

    public String getMessage() {
        return getElementText(headerMessage);
    }

    public boolean loginIsDisplayed() {
        return elementIsDisplayed(loginBtn);
    }
}
