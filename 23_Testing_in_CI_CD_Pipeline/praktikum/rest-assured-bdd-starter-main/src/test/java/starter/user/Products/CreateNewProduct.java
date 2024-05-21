package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewProduct {
    public static String url = "https://altashop-api.fly.dev/api/products";

    @Step("I set the API Endpoint to create new product")
    public String setAPIEndpointCreateNewProduct(){
        return url;
    }

    @Step("I send the request to add a new valid product")
    public void sendRequestAddNewValidProduct(){
        JSONObject responseBody = new JSONObject();
        responseBody.put("name", "Sambal Bawang");
        responseBody.put("description", "Sambal bawang terbaik");
        responseBody.put("price", 30000);

        JSONArray categories = new JSONArray();
        categories.put(32466);
        responseBody.put("categories", categories);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(responseBody.toString())
                .post(setAPIEndpointCreateNewProduct());
    }

    @Step("I send the request to add a new invalid product")
    public void sendRequestAddNewInvalidProduct(){
        JSONObject responseBody = new JSONObject();
        responseBody.put("name", JSONObject.NULL);
        responseBody.put("description", JSONObject.NULL);
        responseBody.put("price", JSONObject.NULL);
        responseBody.put("categories", JSONObject.NULL);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(responseBody.toString())
                .post(setAPIEndpointCreateNewProduct());
    }

    @Step("I get status code 200 after create a new valid product")
    public void getStatus200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get status code 500")
    public void getStatus500(){
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I got new data product that i wanted to sell")
    public void receiveNewDataProductWantedSell(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.equalTo("Sambal Bawang")));
        restAssuredThat(response -> response.body("data.Description", Matchers.equalTo("Sambal bawang terbaik")));
        restAssuredThat(response -> response.body("data.Price", Matchers.equalTo(30000)));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.equalTo(0)));
        restAssuredThat(response -> response.body("data.Categories", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
