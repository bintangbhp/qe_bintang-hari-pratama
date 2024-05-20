package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllProducts {
    private static String url = "https://fakestoreapi.com/";
    @Step("I set the API endpoint to retrieve all data products")
    public String setApiEndpointAllProducts(){
        return url + "products";
    }

    @Step("I send a request to retrieve all data products")
    public void sendRequestAllProducts(){
        SerenityRest.given()
                .get(setApiEndpointAllProducts());
    }

    @Step("I should receive a status code of 200")
    public void receiveStatusCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I should receive valid data for all products")
    public void receiveValidAllDataProducts(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS_SCHEMA);

        restAssuredThat(response -> response.body("'id'", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("'title'", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("'price'", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("'description'", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("'category'", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("'rating.rate'", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("'rating.count'", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
