package starter.user.ProductCategories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetCategoryById {
    private static String url  = "https://altashop-api.fly.dev/api/categories/";

    @Step("I set the API Endpoint to get product category")
    public String setAPIEndpointGetCategory(){
        return url;
    }

    @Step("I send the request to get product category by valid Id")
    public void sendGetValidCategoryRequest() {
        SerenityRest.given()
                .get(setAPIEndpointGetCategory() + "32486");
    }

    @Step("I send the request to get product category by invalid Id")
    public void sendGetInvalidCategoryRequest() {
        SerenityRest.given()
                .get(setAPIEndpointGetCategory() + "99999999");
    }

    @Step("I get status code 200 after request to get product category by valid Id")
    public void getStatus200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get status code 404")
    public void getStatus404() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive product category")
    public void receiveAllDataCategory(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CATEGORY_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Description", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
