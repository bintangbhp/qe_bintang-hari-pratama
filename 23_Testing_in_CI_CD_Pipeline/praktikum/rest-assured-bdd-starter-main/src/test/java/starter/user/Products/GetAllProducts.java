package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllProducts {
    public static String url = "https://altashop-api.fly.dev/api/products";

    @Step("I set the API Endpoint to get all products")
    public String setAPIEndpointGetAllProducts(){
        return url;
    }

    @Step("I send the request to get all products")
    public void sendRequestGetAllProducts(){
        SerenityRest.given()
                .get(setAPIEndpointGetAllProducts());
    }

    @Step("I get status code 200 after request to get all product")
    public void getStatus200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get status code 400")
    public void getStatus400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I receive all data products")
    public void receiveAllDataProducts(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Description", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Price", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Categories", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //Negatif Scenario
    @Step("I send the request to get all products with invalid method")
    public void sendRequestInvalidMethod(){
        SerenityRest.given()
                .post(setAPIEndpointGetAllProducts()); //harusnya get
    }
}
