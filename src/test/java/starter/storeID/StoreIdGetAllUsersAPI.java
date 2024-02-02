package starter.storeID;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import starter.utils.Constants;
import net.thucydides.core.annotations.Step;
public class StoreIdGetAllUsersAPI {
    public static String GET_ALL_USERS = Constants.BASE_URL+ "/alluser";
    public static String GET_ALL_USERS_INVALID = Constants.BASE_URL+ "/allusers";
    public static String GET_ALL_USERS_EMPTY = Constants.BASE_URL+ "/";

    @Step("Get all users with valid path")
    public void GetAllUserValidPath() {
        SerenityRest.given()
                .get(Constants.BASE_URL+ "/alluser");
    }

    @Step("Get all users with invalid path")
    public void GetAllUserInvalidPath() {
        SerenityRest.given()
                .get(Constants.BASE_URL+ "/allusers");
    }

    @Step("Get all users with empty path")
    public void GetAllUserEmptyPath() {
        Response response = SerenityRest.given()
                .get(Constants.BASE_URL+ "/");
        int statusCode = response.getStatusCode();
        Assert.assertEquals("Status code should be 404", 404, statusCode);
    }
}
