package cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.todko.web.Creds;
import net.todko.web.WebDriverFramework;
import net.todko.web.pageobjects.LogInPage;
import net.todko.web.pageobjects.StorePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Site extends WebDriverFramework {

    public static final String LANDING_PAGE_URL = "http://todko.net";
    public static LogInPage logInPage;
    public static StorePage store;

    @Given("The Landing Page")
    public void the_landing_page() {
        WebDriverFramework.setUpChrome();
        driver.get(LANDING_PAGE_URL);
        logInPage = new LogInPage();
        checkDisplayed(logInPage.logInBtn);
    }

    @When("User provides {string} creds")
    public void user_provides_some_creds(String credsProvided) {
        Creds currentCreds = Creds.resolveCreds(credsProvided);

        logInPage.enterUserName(currentCreds.user);
        logInPage.enterPassword(currentCreds.pass);
        store = logInPage.submitCreds();
    }

    @Then("User should not be logged in")
    public void user_should_not_be_logged_in() {
        checkDisplayed(logInPage.logInBtn);
    }

    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        checkDisplayed(store.logOutBtn);
    }

    @Given("The Store Page")
    public void theStorePage() {
        WebDriverFramework.setUpChrome();
        driver.get(LANDING_PAGE_URL);
        logInPage = new LogInPage();
        store = logInPage.logIn(Creds.resolveCreds("right"));
        checkDisplayed(store.logOutBtn);
    }

    @When("User clicks on buy pencil")
    public void userClicksOnBuyPencil() {
        store.buyPencil();
    }

    @Then("User receives confirmation")
    public void userReceivesConfirmation() {
        checkDisplayed(store.thankYou);
    }

    @After
    public void afterScenario() {
        tearDown();
    }

    @When("User clicks on buy perforator")
    public void userClicksOnBuyPerforator() {
        store.buyPerforatorPosition(1);
    }

    @Then("User receives js confirmation")
    public void userReceivesJsConfirmation() {
        checkDisplayed(store.thankYou);
    }

    @And("User {string} JS alert")
    public void userJSAlert(String choice) {
        store.answerBuyAlert(choice.equals("accepts"));
    }

    @When("User clicks LogOut")
    public void userClicksLogOut() {
        logInPage = store.logOut();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(logInPage.logInBtn));
    }

    @And("User sees login failure")
    public void userSeesLoginFailure() {
        checkDisplayed(logInPage.failedLoginMsg);
    }
}
