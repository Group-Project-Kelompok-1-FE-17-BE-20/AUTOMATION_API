package starter.storeID;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class StoreIDDeleteUsersAPI {

    public static String DELETE_USER = Constants.BASE_URL+"/users";
    @Step("Delete user with valid")
    public void deleteValidUser(){
        SerenityRest.given()
                .header("Authorization", "Bearer "+ Constants.CONSTANT_TOKEN);
    }
//    @Step("Delete user with invalid id")
//    public void deleteInvalidUser(String id){
//        SerenityRest.given()
//                .pathParam("id", id);
//    }
}
