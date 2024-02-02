package starter.storeID;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class StoreIDUpdateUsersAPI {
    public static String UPDATE_USER = Constants.BASE_URL+"/users";

    @Step ("Update user with valid image")
    public void updateUserValidImage (File image) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.CONSTANT_TOKEN)
                .multiPart("image", image, "image/jpg");
    }
}
