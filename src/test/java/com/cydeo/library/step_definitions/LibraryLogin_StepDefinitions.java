package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Wait;

public class LibraryLogin_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    LandingPage landingPage = new LandingPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user login is as librarian")
    public void user_login_is_as_librarian() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("librarian1Username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("librarian1Password"));
        loginPage.loginBtn.click();
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {

        String expecteddashboardText = "Dashboard";
        String actualdashboardText = dashboardPage.dashboard.getText();


        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard") );
        Assert.assertEquals(expecteddashboardText, actualdashboardText);
    }

    @When("user login as student")
    public void userLoginAsStudent() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("student1Username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("student1Password"));
        loginPage.loginBtn.click();
    }

    @Then("user should see the book dashboard")
    public void userShouldSeeTheBookDashboard() {
        String expectedBookText = "books";

        Assert.assertTrue("Books is not appear on URL",Driver.getDriver().getCurrentUrl().contains(expectedBookText));
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
     loginPage.usernameInput.sendKeys(username);
    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
    loginPage.passwordInput.sendKeys(password);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
     loginPage.loginBtn.click();
    }
    @And("there should be {string} users")
    public void thereShouldBeUsers(String numberOfUser) {
        String actualUserCount = landingPage.userCount.getText();
        Assert.assertEquals(numberOfUser,actualUserCount);
    }

    @When("user enter {string} to the username input box")
    public void user_enter_to_the_username_input_box(String studentusername) {
     loginPage.usernameInput.sendKeys(studentusername);
    }
    @When("user enter {string} to the password input box")
    public void user_enter_to_the_password_input_box(String studentPassword) {
    loginPage.passwordInput.sendKeys(studentPassword);
    loginPage.loginBtn.click();
    }


}
