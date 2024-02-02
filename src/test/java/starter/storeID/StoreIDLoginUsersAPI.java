package starter.storeID;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class StoreIDLoginUsersAPI {

public static String LOGIN_USER = Constants.BASE_URL+"/login";
    @Step("Post login user")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
