package starter.storeID;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class StoreIDCreateUsersAPI {

    public static String POST_CREATE_USER = Constants.BASE_URL+"/users";
    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
