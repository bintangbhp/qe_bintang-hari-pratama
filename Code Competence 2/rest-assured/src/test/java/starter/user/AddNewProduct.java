package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AddNewProduct {
    private static String url = "https://fakestoreapi.com/";

    @Step("I set the API endpoint for adding a new product")
    public String setAPIAddNewProduct(){
        return url + "products";
    }

    @Step("I submit a request to add a new product with valid credentials")
    public void sendRequestAddNeqProduct(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "test product");
        requestBody.put("price", 13.5);
        requestBody.put("description", "lorem ipsum set");
        requestBody.put("image", "https://i.pravatar.cc");
        requestBody.put("category", "electronic");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIAddNewProduct());
    }

    @Step("I should receive confirmation that the new product has been successfully added")
    public void receiveNewProductData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ADD_NEW_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("id", Matchers.equalTo(21)));
        restAssuredThat(response -> response.body("title", Matchers.equalTo("test product")));
        restAssuredThat(response -> response.body("price", Matchers.equalTo(13.5f)));
        restAssuredThat(response -> response.body("description", Matchers.equalTo("lorem ipsum set")));
        restAssuredThat(response -> response.body("image", Matchers.equalTo("https://i.pravatar.cc")));
        restAssuredThat(response -> response.body("category", Matchers.equalTo("electronic")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
