package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class UpdateCartData {
    public static String url = "https://fakestoreapi.com/carts/7";

    @Step("I set the API endpoint for update a specific cart data")
    public String setAPIUpdatedCartData(){
        return url;
    }

    @Step("I send a request to update cart data")
    public void sendRequestUpdateCartData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 3);
        requestBody.put("date", "2019-11-09");

        JSONArray productsArray = new JSONArray();
        JSONObject product = new JSONObject();
        product.put("productId", 1);
        product.put("quantity", 3);
        productsArray.put(product);

        requestBody.put("products", productsArray);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setAPIUpdatedCartData());
    }

    @Step("I should get the data cart that I updated")
    public void receiveDataCartUpdated(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_CART_DATA_SCHEMA);

        restAssuredThat(response -> response.body("id", Matchers.equalTo(7)));
        restAssuredThat(response -> response.body("userId", Matchers.equalTo(3)));
        restAssuredThat(response -> response.body("date", Matchers.equalTo("2019-11-09")));
        restAssuredThat(response -> response.body("products[0].productId", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("products[0].quantity", Matchers.equalTo(3)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
