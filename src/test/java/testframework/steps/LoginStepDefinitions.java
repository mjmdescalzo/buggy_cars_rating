package testframework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import testframework.pages.Header;
import testframework.pages.HomePage;
import testframework.pages.RegistrationPage;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    Hooks hooks;
    Header header;

    public LoginStepDefinitions(Hooks hooks) {
        this.hooks = hooks;
        header = new Header(hooks.driver, hooks.wait);
    }

    @Given("I populate the Login Fields")
    public void iHaveOpenTheChromeBrowser(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            switch (columns.get("field")) {
                case "Login":
                    header.enterUsername(columns.get("value"));
                    break;
                case "Password":
                    header.enterPassword(columns.get("value"));
                    break;
            }
        }
    }

    @When("I click the Login button")
    public void iClickTheLoginButton() {
        header.clickLogin();
    }

    @Then("the welcome message should be displayed")
    public void theWelcomeMessageShouldBeDisplayed(String expectedMessage) {
        Assert.assertTrue("Failed: Unsuccessful login", header.getMessage().equals(expectedMessage));
    }

    @Then("the error message is displayed at the Header")
    public void theErrorMessageIsDisplayedAtTheHeader(String expectedMessage) {
        Assert.assertTrue("Failed: User should not be able to login", header.getMessage().equals(expectedMessage));
    }

    @When("I click the Logout button")
    public void iClickTheLogoutButton() {
        header.clickLogout();
    }

    @Then("the is now logged out")
    public void theIsNowLoggedOut() {
        Assert.assertTrue("Failed: User should now be logged out", header.loginIsDisplayed());
    }
}
