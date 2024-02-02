package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.StoreIdGetAllUsersAPI;
import starter.storeID.StoreIdResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllUserStepDef {
    @Steps
    StoreIdGetAllUsersAPI storeIdGetAllUsersAPI;

    @Given("Get all users with valid path")
    public void getAllUsersWithValidPath()
    {
        storeIdGetAllUsersAPI.GetAllUserValidPath();
    }

    @When("Send request get all users")
    public void sendRequestGetAllUsers()
    {
        SerenityRest.when().get(StoreIdGetAllUsersAPI.GET_ALL_USERS);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode)
    {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body code should be {int}")
    public void responseBodyCodeShouldBe(int code)
    {
        SerenityRest.and()
                .body(StoreIdResponses.CODE, equalTo(code));
    }

    @And("Validate get all users json schema {string}")
    public void validateGetAllUsersJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send request get all users with invalid path")
    public void sendRequestGetAllUsersWithInvalidPath()
    {
        SerenityRest.when().get(StoreIdGetAllUsersAPI.GET_ALL_USERS_INVALID);
    }

    @And("Validate get all users invalid json schema {string}")
    public void validateGetAllUsersInvalidJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get all users with empty path")
    public void getAllUsersWithEmptyPath()
    {
        SerenityRest.when().get(StoreIdGetAllUsersAPI.GET_ALL_USERS_EMPTY);
    }
}
