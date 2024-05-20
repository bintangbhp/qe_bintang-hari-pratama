package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteSpecificUser {
    public static String url = "https://fakestoreapi.com/users/";

    @Step("I set the API endpoint to delete a specific user")
    public String setAPIEndpointDeleteSpecificUser(){
        return url + "6";
    }

    @Step("I send a request to delete a specific user")
    public void sendRequestDeleteSpecificUser(){
        SerenityRest.given()
                .delete(setAPIEndpointDeleteSpecificUser());
    }

    @Step("I should receive data for the user that has been deleted")
    public void receiveDeletedData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.DELETE_SPECIFIC_USER_SCHEMA);

        restAssuredThat(response -> response.body("id", Matchers.equalTo(6)));
        restAssuredThat(response -> response.body("email", Matchers.equalTo("david_r@gmail.com")));
        restAssuredThat(response -> response.body("username", Matchers.equalTo("david_r")));
        restAssuredThat(response -> response.body("password", Matchers.equalTo("3478*#54")));
        restAssuredThat(response -> response.body("name.firstname", Matchers.equalTo("david")));
        restAssuredThat(response -> response.body("name.lastname", Matchers.equalTo("russell")));
        restAssuredThat(response -> response.body("phone", Matchers.equalTo("1-678-345-9856")));
        restAssuredThat(response -> response.body("address.geolocation.lat", Matchers.equalTo("20.1677")));
        restAssuredThat(response -> response.body("address.geolocation.long", Matchers.equalTo("-10.6789")));
        restAssuredThat(response -> response.body("address.city", Matchers.equalTo("el paso")));
        restAssuredThat(response -> response.body("address.street", Matchers.equalTo("prospect st")));
        restAssuredThat(response -> response.body("address.number", Matchers.equalTo(124)));
        restAssuredThat(response -> response.body("address.zipcode", Matchers.equalTo("12346-0456")));
        restAssuredThat(response -> response.body("__v", Matchers.equalTo(0)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
