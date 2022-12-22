package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.Login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login_Steps {

    private Login_Page lgn = new Login_Page(WebdriverIntializer.getDriver());

    @Given("Enter the username and password {string} {string}")
    public void enter_the_username_and_password(String Username, String Password) {
        lgn.enterUsername(Username);
        lgn.enterPassword(Password);
    }

    @When("click on login")
    public void click_on_login() {

        lgn.clickOnSignin();

    }

    @Then("verify the home page")
    public void verify_the_home_page() {
        lgn.verifyTheLogin();
    }

}
