package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateDataProduct {
    public static String url = "https://fakestoreapi.com/products";

    @Step("I set the API endpoint to update product data")
    public String setApiEndpointUpdateData(){
        return url + "/7";
    }

    @Step("I submit a request to update product data with valid credentials")
    public void sendRequestUpdateData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "test product");
        requestBody.put("price", 13.5);
        requestBody.put("description", "lorem ipsum set");
        requestBody.put("image", "https://i.pravatar.cc");
        requestBody.put("category", "electronic");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setApiEndpointUpdateData());
    }

    @Step("I should receive valid data confirming the updated product information")
    public void receiveUpdatedProductData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_DATA_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("id", equalTo(7)));
        restAssuredThat(response -> response.body("title", equalTo("test product")));
        restAssuredThat(response -> response.body("price", equalTo(13.5f)));
        restAssuredThat(response -> response.body("description", equalTo("lorem ipsum set")));
        restAssuredThat(response -> response.body("image", equalTo("https://i.pravatar.cc")));
        restAssuredThat(response -> response.body("category", equalTo("electronic")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
