package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

import java.security.SecureRandom;

public class Register {
    public static String url = "https://altashop-api.fly.dev/api/auth/register";
    public static String email = randomStringGenerator() + "@mail.com";

    @Step("I set the API Endpoint to register")
    public String setAPIEndpointRegister(){
        return url;
    }

    @Step("I send the request to register a valid account")
    public void sendRequestRegisterNewValidAccount(){
        JSONObject responseBody = new JSONObject();
        responseBody.put("email", email);
        responseBody.put("password", "123123");
        responseBody.put("fullname", "Bintang Pratama");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(responseBody.toString())
                .post(setAPIEndpointRegister());
    }

    @Step("I send the request to register an invalid account")
    public void sendRequestRegisterNewInvalidAccount(){
        JSONObject responseBody = new JSONObject();
        responseBody.put("email", JSONObject.NULL);
        responseBody.put("password", JSONObject.NULL);
        responseBody.put("fullname", JSONObject.NULL);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(responseBody.toString())
                .post(setAPIEndpointRegister());
    }

    @Step("I get status code 200 after register a valid account")
    public void getStatus200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get status code 400 after register an invalid account")
    public void getStatus400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I got data of your account")
    public void receiveRegisteredAccountData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.REGISTER_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Email", Matchers.equalTo(email)));
        restAssuredThat(response -> response.body("data.Password", Matchers.equalTo("123123")));
        restAssuredThat(response -> response.body("data.Fullname", Matchers.equalTo("Bintang Pratama")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    private static String randomStringGenerator(){
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
