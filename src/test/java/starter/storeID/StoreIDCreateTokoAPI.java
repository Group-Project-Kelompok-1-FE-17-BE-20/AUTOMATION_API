package starter.storeID;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class StoreIDCreateTokoAPI {

    public static String POST_CREATE_TOKO = Constants.BASE_URL+"/stores";
    @Step("Post create toko")
    public void postCreateToko(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer "+ Constants.CONSTANT_TOKEN)
                .header("Content-Type", "application/json")
                .body(json);
    }
}
