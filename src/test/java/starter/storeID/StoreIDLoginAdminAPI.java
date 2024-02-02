package starter.storeID;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class StoreIDLoginAdminAPI {
    public static String LOGIN_ADMIN= Constants.BASE_URL+"/admin-login";
    @Step("Post login admin")
    public void postLoginAdmin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
