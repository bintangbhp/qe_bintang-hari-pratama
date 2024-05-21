package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Login {
    public static String url = "https://altashop-api.fly.dev/api/auth/login";

    @Step("I set the API Endpoint to login")
    public String setAPIEndpointLogin(){
        return url;
    }

    @Step("I send the request to login a valid account")
    public void sendRequestLoginValidAccount(){
        JSONObject responseBody = new JSONObject();
        responseBody.put("email", "bintang@gmail.com");
        responseBody.put("password", "123123");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(responseBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I send the request to login an invalid account")
    public void sendRequestLoginInvalidAccount(){
        JSONObject responseBody = new JSONObject();
        responseBody.put("email", JSONObject.NULL);
        responseBody.put("password", JSONObject.NULL);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(responseBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I get status code 200 after login a valid account")
    public void getStatus200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get status code 400 after login an invalid account")
    public void getStatus400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I got data of bearer token")
    public void receiveRegisteredAccountData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_SCHEMA);

        restAssuredThat(response -> response.body("data", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
