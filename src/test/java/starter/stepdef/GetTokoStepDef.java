package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.Store_idAPI;
import starter.utils.Constants;

import java.io.File;

public class GetTokoStepDef {
    @Steps
    Store_idAPI store_idAPI;
    @Given("Get toko")
    public void getToko() {
        store_idAPI.getToko();

    }

    @When("Send request get toko")
    public void sendRequestGetToko() {
        SerenityRest.when().get(Store_idAPI.GET_TOKO);

    }
// update
@Given("Update toko with {string} and {string}")
public void updateTokoWithTokoidAnd(String toko_id, String json) {
    // Assuming Constants.REQ_BODY is the base path for your JSON files
    String jsonFilePath = Constants.REQ_BODY + json;

    // Create a File object from the JSON file path
    File jsonUpdateProduct = new File(jsonFilePath);

    // Update the product using the redstoreUpdateProductAPI
    store_idAPI.updateTokoLogin(toko_id, jsonUpdateProduct);
}

    @When("Send request update product")
    public void sendRequestUpdateProduct() {
        // No additional logic needed here, as the product creation is done in the Given step
    }

    @Given("Post toko with {string}")
    public void postTokoWithAnd(String json) {
        String jsonFilePath = Constants.REQ_BODY + json;
        File jsonPostToko = new File(jsonFilePath);
        store_idAPI.postToko(jsonPostToko);
    }

    @When("Send request post toko")
    public void sendRequestPostToko() {
        SerenityRest.when()
                .post(Store_idAPI.POST_TOKO);
    }

    @Given("Delete toko with {string}")
    public void deleteTokoWith(String toko_id) {
        store_idAPI.deleteToko(toko_id);
    }

    @When("Send request delete toko")
    public void sendRequestDeleteToko() {
        SerenityRest.when().delete(Store_idAPI.DELETE_TOKO);

    }

}
