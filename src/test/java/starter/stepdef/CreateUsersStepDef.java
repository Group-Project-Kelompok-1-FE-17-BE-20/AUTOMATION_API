package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.StoreIDCreateUsersAPI;
import starter.storeID.StoreIdGetAllUsersAPI;
import starter.storeID.StoreIdResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUsersStepDef {

    @Steps
    StoreIDCreateUsersAPI storeIDCreateUsersAPIUsersAPI;

    @Given("Post Create user with valid json {string}")
    public void postCreateUserWithValidJson(String json)
    {
        File jsonCreateUser = new File(Constants.REQ_BODY+ json);
        storeIDCreateUsersAPIUsersAPI.postCreateUser(jsonCreateUser);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser()
    {
        SerenityRest.when().post(StoreIDCreateUsersAPI.POST_CREATE_USER);
    }

    @And("Response body code was {int} and message was {string}")
    public void responseBodyCodeWasAndMessageWas(int code, String message)
    {
        SerenityRest.and()
                .body(StoreIdResponses.CODE, equalTo(code))
                .body(StoreIdResponses.MESSAGE, equalTo(message));
    }

    @And("Validate create user json schema {string}")
    public void validateCreateUserJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post create user with invalid json {string}")
    public void postCreateUserWithInvalidJson(String json)
    {
        File jsonCreateUser = new File(Constants.REQ_BODY+ json);
        storeIDCreateUsersAPIUsersAPI.postCreateUser(jsonCreateUser);
    }
}
