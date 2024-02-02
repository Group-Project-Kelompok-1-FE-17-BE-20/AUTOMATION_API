package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.StoreIDGetSingleUsersAPI;
import starter.storeID.StoreIdGetAllUsersAPI;
import starter.utils.Constants;

import java.io.File;

public class GetSingleUsersStepDef {

    @Steps
    StoreIDGetSingleUsersAPI storeIDGetSingleUsersAPI;

    @Given("Get single user with valid")
    public void getSingleUserWithValid()
    {
        storeIDGetSingleUsersAPI.getSingleUser();
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser()
    {
        SerenityRest.when()
                .get(StoreIDGetSingleUsersAPI.GET_SINGLE_USER);
    }

    @And("Validate get single users json schema {string}")
    public void validateGetSingleUsersJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
