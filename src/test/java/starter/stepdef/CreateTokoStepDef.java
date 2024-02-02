package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.StoreIDCreateTokoAPI;
import starter.storeID.StoreIDCreateUsersAPI;
import starter.storeID.StoreIdResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateTokoStepDef {
    @Steps
    StoreIDCreateTokoAPI storeIDCreateTokoAPI;

    @Given("Post Create toko with valid json {string}")
    public void postCreateTokoWithValidJson(String json) {
        File jsonCreateToko = new File(Constants.REQ_BODY+ json);
        storeIDCreateTokoAPI.postCreateToko(jsonCreateToko);
    }


    @When("Send request post create toko")
    public void sendRequestPostCreateToko()
    {
        SerenityRest.when().post(StoreIDCreateTokoAPI.POST_CREATE_TOKO);
    }


    @And("Validate create toko json schema {string}")
    public void validateCreateTokoJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


}
