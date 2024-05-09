package StepDef;

import Pages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.bytebuddy.asm.Advice;
// Bikin file ke 2
public class ApiStepdef{
    ApiPage apiPage;

    public ApiStepdef(){
        this.apiPage = new ApiPage();
    }

    @Given("Prepare URL valid for {string}")
    public void prepareURLValidFor(String URL) {
        apiPage.prepareURLValidFor(URL);
    }

    @And("Hit API get list data")
    public void hitAPIGetListData() {
        apiPage.hitAPIGetListData();
    }

    @Then("Validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statusCode) {
        apiPage.validationStatusCodeIsEquals(statusCode);
    }

    @Then("Validation response body get list user")
    public void validationResponseBodyGetListUser() {
        apiPage.validationResponseBodyGetListUser();
    }

    @Then("Validation response json whit JSONSchema {string}")
    public void validationResponseJsonWhitJSONSchema(String fileJSON) {
        apiPage.validationResponseJsonWhitJSONSchema(fileJSON);
    }

    @And("Hit API Post user")
    public void hitAPIPostUser() {
        apiPage.hitAPIPostUser();
    }

    @Then("Validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationResponseBodyPostCreateNewUser();
    }


    @And("Hit API update data")
    public void hitAPIUpdateData() {
        apiPage.hitAPIUpdateData();
    }

    @Then("Validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }

    @And("Hit API delete new")
    public void hitAPIDeleteNew() {
        apiPage.hitAPIDeleteNew();
    }
}
