package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.StoreIDLoginAdminAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginAdminStepDef {
    @Steps
    StoreIDLoginAdminAPI storeIDLoginAdminAPI;

    @Given("Login admin with valid {string}")
    public void loginAdminWithValid(String json)
    {
        File jsonLoginAdmin = new File(Constants.REQ_BODY+ json);
        storeIDLoginAdminAPI.postLoginAdmin(jsonLoginAdmin);
    }

    @When("Send request post login admin")
    public void sendRequestPostLoginAdmin()
    {
        SerenityRest.when()
                .post(StoreIDLoginAdminAPI.LOGIN_ADMIN);
    }

    @And("Validate login admin json schema {string}")
    public void validateLoginAdminJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
