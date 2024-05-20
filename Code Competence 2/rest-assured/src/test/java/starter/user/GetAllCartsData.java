package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllCartsData {
    public static String url = "https://fakestoreapi.com/";

    @Step("I set the API endpoint to retrieve all carts data")
    public String setAPIEndpointAllCartsData(){
        return url + "carts";
    }

    @Step("I submit a request to the API endpoint to retrieve all carts data")
    public void sendAPIEndpointAllCartsData(){
        SerenityRest.given()
                .get(setAPIEndpointAllCartsData());
    }

    @Step("I should receive data for all carts data")
    public void receiveAllCartsData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CARTS_DATA_SCHEMA);

        restAssuredThat(response -> response.body("id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("userId", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("date", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("products.productId", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("products.quantity", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("__v", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
