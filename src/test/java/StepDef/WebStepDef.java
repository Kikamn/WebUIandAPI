package StepDef;

import Pages.WebPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebStepDef {
    WebPage webPage;
    public WebStepDef(){
        this.webPage = new WebPage();
    }

    @Given("User in login page")
    public void userInLoginPage() {
        webPage.toLogin();
    }

    @And("User input username {string}")
    public void userInputUsername(String username) {
        webPage.userInputUsername(username);
    }

    @When("User input password {string}")
    public void userInputPassword(String password) {
        webPage.userInputPassword(password);
    }

    @And("User click button login")
    public void userClickButtonLogin() {
        webPage.userClickButtonLogin();
    }

    @Then("userCanLogin")
    public void usercanlogin() {
        webPage.userCanLogin();
    }

    @Then("Will show error {string}")
    public void willShowError(String errorMassage) {
        webPage.willShowError(errorMassage);
    }

    @And("User click button Burgermenu")
    public void userClickButtonBurgermenu() {
        webPage.userClickButtonBurgermenu();
    }

    @Then("Will show menu in Burgermenu")
    public void willShowMenuInBurgermenu() throws InterruptedException {
        webPage.willShowMenuInBurgermenu();
    }

    @And("User click filer")
    public void userClickFiler() {
        webPage.userClickFiler();
    }

    @Then("Will chose menu in filter")
    public void willChoseMenuInFilter() throws InterruptedException{
        webPage.willChoseMenuInFilter();
    }

    @And("User click button addtocart")
    public void userClickButtonAddtocart() {
        webPage.userClickButtonAddtocart();
    }

    @Then("Can click button addtocart")
    public void canClickButtonAddtocart() {
        webPage.canClickButtonAddtocart();
    }

    @And("User click button remove")
    public void userClickButtonRemove() {
        webPage.userClickButtonRemove();
    }

    @Then("Will back to button addtocart")
    public void willBackToButtonAddtocart() {
        webPage.willBackToButtonAddtocart();
    }
}
