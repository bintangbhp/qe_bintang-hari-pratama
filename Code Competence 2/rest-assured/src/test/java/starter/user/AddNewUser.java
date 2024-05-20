package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AddNewUser {
    public static String url = "https://fakestoreapi.com/users";

    @Step("I set the API endpoint to add a new user")
    public String setAPIEndpointAddNewUser(){
        return url;
    }

    @Step("I send a request to add a new user into system")
    public void sendRequestAddNewUser(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "John@gmail.com");
        requestBody.put("username", "johnd");
        requestBody.put("password", "m38rmF$");

        JSONObject nameObject = new JSONObject();
        nameObject.put("firstname", "John");
        nameObject.put("lastname", "Doe");
        requestBody.put("name", nameObject);

        JSONObject addressObject = new JSONObject();
        addressObject.put("city", "kilcoole");
        addressObject.put("street", "7835 new road");
        addressObject.put("number", 3);
        addressObject.put("zipcode", "12926-3874");

        JSONObject geolocationObject = new JSONObject();
        geolocationObject.put("lat", "-37.3159");
        geolocationObject.put("long", "81.1496");

        addressObject.put("geolocation", geolocationObject);
        requestBody.put("address", addressObject);

        requestBody.put("phone", "1-570-236-7033");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointAddNewUser());

    }

    @Step("I should receive a newly added user ID")
    public void receiveUserID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ADD_NEW_USER_SCHEMA);

        restAssuredThat(response -> response.body("id", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
