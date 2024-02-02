package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.storeID.StoreIDDeleteUsersAPI;
import starter.storeID.StoreIdGetAllUsersAPI;

public class DeleteUsersStepDef {
    @Steps
    StoreIDDeleteUsersAPI storeIDDeleteUsersAPI;

    @Given("Delete user with valid")
    public void deleteGetUser() {
        storeIDDeleteUsersAPI.deleteValidUser();
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser()
    {
        SerenityRest.when().delete(StoreIDDeleteUsersAPI.DELETE_USER);
    }
}
