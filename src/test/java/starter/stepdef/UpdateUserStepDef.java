package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.StoreIDLoginUsersAPI;
import starter.storeID.StoreIDUpdateUsersAPI;
import starter.storeID.StoreIdResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserStepDef {

    @Steps
    StoreIDUpdateUsersAPI storeIDUpdateUsersAPI;

    @Given("User updated image {string}")
    public void userUpdatedEmail(String image)
    {
        File imageProduct = new File (Constants.IMAGE_DIR, image);
        storeIDUpdateUsersAPI.updateUserValidImage(imageProduct);
    }

    @When("Send PUT request to update user")
    public void sendPUTRequestToUpdateUser()
    {
        SerenityRest.when().put(StoreIDUpdateUsersAPI.UPDATE_USER);
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message)
    {
        SerenityRest.and()
                .body(StoreIdResponses.MESSAGE, equalTo(message));
    }

    @And("Validate JSON schema {string}")
    public void validateJSONSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
