package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProduct {
    private static String url  = "https://altashop-api.fly.dev/api/products/";

    @Step("I set API endpoint for delete product")
    public String setAPIEndpointDeleteProduct() {
        return url;
    }

    @Step("I send a request to delete a valid product")
    public void sendDeleteValidProductRequest() {
        SerenityRest.given()
                .delete(setAPIEndpointDeleteProduct() + "88803");
    }

    @Step("I send a request to delete an invalid product")
    public void sendDeleteInvalidProductRequest() {
        SerenityRest.given()
                .delete(setAPIEndpointDeleteProduct() + "-1");
    }

    @Step("I get status code 200 after request to delete a valid product")
    public void getStatus200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get status code 500 after request to delete an invalid product")
    public void getStatus500() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I get a successfull message")
    public void getSuccessfullMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.DELETE_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
