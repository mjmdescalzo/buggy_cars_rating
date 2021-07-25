package testframework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import testframework.pages.Header;
import testframework.pages.HomePage;
import testframework.pages.RegistrationPage;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class RegistrationStepDefinitions {

    Hooks hooks;
    Header header;
    HomePage homePage;
    RegistrationPage registrationPage;

    public RegistrationStepDefinitions(Hooks hooks) {
        this.hooks = hooks;
        header = new Header(hooks.driver, hooks.wait);
        homePage = new HomePage(hooks.driver, hooks.wait);
        registrationPage = new RegistrationPage(hooks.driver, hooks.wait);
    }

    @Given("I have open the Chrome Browser")
    public void iHaveOpenTheChromeBrowser() {
        hooks.driver.get("https://buggy.justtestit.org/");
    }

    @Given("I am at the Home Page")
    public void iAmAtTheHomePage() {
        Assert.assertTrue("Failed: Not in home page", homePage.isInHomePage());
    }

    @When("I click Register at the header")
    public void iClickRegister() {
        header.clickRegister();
    }

    @Given("I am the Registration Page")
    @Then("I am redirected to the Registration Page")
    public void iAmRedirectedToTheRegistrationPage() {
        header.clickRegister();
        Assert.assertTrue("Failed: Not in registration page", registrationPage.isInRegistrationPage());
    }


    @And("I populate the Registration Fields")
    public void iPopulateTheRegistrationFields(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            switch (columns.get("field")) {
                case "Login":
                    if (columns.get("value") != null) {
                        Date date = new Date();
                        long time = date.getTime();
                        String login = "";
                        login = columns.get("value").replaceAll("<timestamp>", String.valueOf(time));

                        registrationPage.enterLogin(login);
                    }
                    break;
                case "First Name":
                    registrationPage.enterFirstName(columns.get("value"));
                    break;
                case "Last Name":
                    registrationPage.enterLastName(columns.get("value"));
                    break;
                case "Password":
                    registrationPage.enterPassword(columns.get("value"));
                    break;
                case "Confirm Password":
                    registrationPage.enterConfirmPassword(columns.get("value"));
                    break;
            }
        }
    }

    @When("I click the Register button")
    public void iClickTheRegisterButton() {
        registrationPage.clickRegister();
    }

    @Then("the registration message should be displayed")
    public void theRegistrationMessageShouldBeDisplayed(String expectedMessage) {
        Assert.assertTrue("Failed: Error message is incorrect", registrationPage.getMessage().equals(expectedMessage));
    }

    @Then("registration should be disabled")
    public void registrationShouldBeDisabled() {
        Assert.assertTrue("Failed: Registration should be disabled", registrationPage.registrationIsDisabled());
    }
}
