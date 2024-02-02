package starter.storeID;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class Store_idAPI {
    public static String GET_TOKO = Constants.BASE_URL+"/stores";

    @Step("Get Toko")
    public void getToko(){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_KEI);
    }

    //Update Toko
    public static String UPDATE_PRODUCT = Constants.BASE_URL+"/stores/{toko_id}";

    @Step("update toko login")
    public void updateTokoLogin(String toko_id, File json) {
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_KEI)
                .pathParam("toko_id", toko_id)
                .contentType("multipart/form-data")
                .multiPart("jsonFile", json, "application/json")
                .when()
                .put(UPDATE_PRODUCT);
    }
// POST
    public static String POST_TOKO = Constants.BASE_URL+"/stores";

    @Step("post toko")
    public void postToko(File json) {
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_KEI)
                .contentType("multipart/form-data")
                .multiPart("jsonFile", json, "application/json");
    }
// DELETE
    public static String DELETE_TOKO = Constants.BASE_URL+"/stores/{toko_id}";
    @Step("Delete toko")
    public void deleteToko(String toko_id){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_KEI)
                .pathParam("toko_id", toko_id);

    }
}
