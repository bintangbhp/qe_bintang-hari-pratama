package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetASingleProduct {
    public static String url = "https://fakestoreapi.com/products";

    @Step("I set the API endpoint to retrieve single product data")
    public String setApiEndpointSingleProduct(){
        return url + "/1";
    }

    @Step("I send a request to fetch the single product data information")
    public void sendRequestSingleProduct(){
        SerenityRest.given()
                .get(setApiEndpointSingleProduct());
    }

    @Step("I should receive the data for the single product that I have chosen")
    public void receiveSingleDataProduct(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_A_SINGLE_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("id", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("title", Matchers.equalTo("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops")));
        restAssuredThat(response -> response.body("price", Matchers.equalTo(109.95f)));
        restAssuredThat(response -> response.body("description", Matchers.equalTo("Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday")));
        restAssuredThat(response -> response.body("category", Matchers.equalTo("men's clothing")));
        restAssuredThat(response -> response.body("image", Matchers.equalTo("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg")));
        restAssuredThat(response -> response.body("rating.rate", Matchers.equalTo(3.9f)));
        restAssuredThat(response -> response.body("rating.count", Matchers.equalTo(120)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
