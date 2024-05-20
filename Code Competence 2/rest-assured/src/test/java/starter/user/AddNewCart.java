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

public class AddNewCart {
    public static String url = "https://fakestoreapi.com/carts";

    @Step("I set the API endpoint for add a product to cart")
    public String setAPIEndpointAddNewCart(){
        return url;
    }

    @Step("I submit a request to add a product to cart")
    public void sendRequestAddNewCart(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 5);
        requestBody.put("date", "2020-02-03");

        JSONArray productsArray = new JSONArray();
        JSONObject product1 = new JSONObject();
        product1.put("productId", 5);
        product1.put("quantity", 1);
        productsArray.put(product1);

        JSONObject product2 = new JSONObject();
        product2.put("productId", 1);
        product2.put("quantity", 5);
        productsArray.put(product2);

        requestBody.put("products", productsArray);


        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointAddNewCart());
    }

    @Step("I should receive confirmation that the product has been successfully added to cart")
    public void receiveNewCartData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ADD_NEW_CART_SCHEMA);

        restAssuredThat(response -> response.body("id", Matchers.equalTo(11)));
        restAssuredThat(response -> response.body("userId", Matchers.equalTo(5)));
        restAssuredThat(response -> response.body("date", Matchers.equalTo("2020-02-03")));
        restAssuredThat(response -> response.body("products[0].productId", Matchers.equalTo(5)));
        restAssuredThat(response -> response.body("products[0].quantity", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("products[1].productId", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("products[1].quantity", Matchers.equalTo(5)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
