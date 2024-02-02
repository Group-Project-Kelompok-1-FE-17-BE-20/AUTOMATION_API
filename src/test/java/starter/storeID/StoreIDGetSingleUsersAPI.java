package starter.storeID;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class StoreIDGetSingleUsersAPI {
    public static String GET_SINGLE_USER = Constants.BASE_URL+"/users";

    @Step("Get Single user")
    public void getSingleUser(){
        SerenityRest.given()
                .header("Authorization", "Bearer "+ Constants.CONSTANT_TOKEN_GET_SINGLE_USER);
    }
}
