package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.StoreIDLoginUsersAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginUsersStepDef {
    @Steps
    StoreIDLoginUsersAPI storeIDLoginUsersAPI;

    @Given("Login user with valid {string}")
    public void loginUserWithValid(String json)
    {
        File jsonLoginUser = new File(Constants.REQ_BODY+ json);
        storeIDLoginUsersAPI.postLoginUser(jsonLoginUser);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser()
    {
        Response response = SerenityRest.when().post(StoreIDLoginUsersAPI.LOGIN_USER);
        String tokenUser = response.jsonPath().get("data.token");
        System.out.println("Token User: " + tokenUser);
    }

    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
