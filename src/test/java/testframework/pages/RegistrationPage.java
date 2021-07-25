package testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class RegistrationPage extends BasePage {

    final By registrationPageLabel = By.xpath("//h2[text() = 'Register with Buggy Cars Rating']");
    final By loginFld = By.id("username");
    final By firstNameFld = By.id("firstName");
    final By lastNameFld = By.id("lastName");
    final By passwordFld = By.id("password");
    final By confirmPasswordFld = By.id("confirmPassword");
    final By registerBtn = By.xpath("//button[text()='Register']");
    final By cancelBtn = By.xpath("//a[text()='Cancel']");
    final By registrationMessage = By.xpath("//div[contains(@class, 'result')]");
    final By alertMessage = By.xpath("//div[contains(@class, 'result')]");

    public RegistrationPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }

    public boolean isInRegistrationPage() {
        return elementIsDisplayed(registrationPageLabel);
    }

    public void enterLogin(String value) {
        enterText(loginFld, value);
    }

    public void enterFirstName(String value) {
        enterText(firstNameFld, value);
    }

    public void enterLastName(String value) {
        enterText(lastNameFld, value);
    }

    public void enterPassword(String value) {
        enterText(passwordFld, value);
    }

    public void enterConfirmPassword(String value) {
        enterText(confirmPasswordFld, value);
    }

    public void clickRegister() {
        clickElement(registerBtn);
    }

    public void clickCancel() {
        clickElement(cancelBtn);
    }

    public String getMessage() {
        return getElementText(registrationMessage);
    }

    public boolean registrationIsDisabled() {
        return isElementEnabled(registerBtn, false);
    }
}
