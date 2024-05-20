package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateSpecificUser {
    public static String url = "https://fakestoreapi.com/users/";

    @Step("I set the API endpoint for update a specific user data")
    public String setAPIEndpointUpdateUserData(){
        return url + "7";
    }

    @Step("I send a request for update a specific user data")
    public void sendRequestUpdateUserData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Joni@gmail.com");
        requestBody.put("username", "johnd");
        requestBody.put("password", "m38rmF$");

        JSONObject nameObject = new JSONObject();
        nameObject.put("firstname", "John");
        nameObject.put("lastname", "Doe");
        requestBody.put("name", nameObject);

        JSONObject addressObject = new JSONObject();
        addressObject.put("city", "Larav");
        addressObject.put("street", "7835 new road");
        addressObject.put("number", 3);
        addressObject.put("zipcode", "12926-3874");

        JSONObject geolocationObject = new JSONObject();
        geolocationObject.put("lat", "-37.3159");
        geolocationObject.put("long", "81.1496");

        addressObject.put("geolocation", geolocationObject);
        requestBody.put("address", addressObject);

        requestBody.put("phone", "1-7586-236-0999");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setAPIEndpointUpdateUserData());
    }

    @Step("I should receive newly updated data for a specific user")
    public void receiveUpdatedData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_SPECIFIC_USER_SCHEMA);

        restAssuredThat(response -> response.body("email", Matchers.equalTo("Joni@gmail.com")));
        restAssuredThat(response -> response.body("username", Matchers.equalTo("johnd")));
        restAssuredThat(response -> response.body("password", Matchers.equalTo("m38rmF$")));
        restAssuredThat(response -> response.body("name.firstname", Matchers.equalTo("John")));
        restAssuredThat(response -> response.body("name.lastname", Matchers.equalTo("Doe")));
        restAssuredThat(response -> response.body("address.city", Matchers.equalTo("Larav")));
        restAssuredThat(response -> response.body("address.street", Matchers.equalTo("7835 new road")));
        restAssuredThat(response -> response.body("address.number", Matchers.equalTo(3)));
        restAssuredThat(response -> response.body("address.zipcode", Matchers.equalTo("12926-3874")));
        restAssuredThat(response -> response.body("address.geolocation.lat", Matchers.equalTo("-37.3159")));
        restAssuredThat(response -> response.body("address.geolocation.long", Matchers.equalTo("81.1496")));
        restAssuredThat(response -> response.body("phone", Matchers.equalTo("1-7586-236-0999")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
