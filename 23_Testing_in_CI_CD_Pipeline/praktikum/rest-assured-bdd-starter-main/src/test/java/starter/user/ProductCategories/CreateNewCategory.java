package starter.user.ProductCategories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewCategory {
    public static String url = "https://altashop-api.fly.dev/api/categories";

    @Step("I set the API Endpoint to create new category")
    public String setAPIEndpointCreateNewCategory(){
        return url;
    }

    @Step("I send the request to add a new valid category")
    public void sendRequestAddNewValidCategory(){
        JSONObject responseBody = new JSONObject();
        responseBody.put("name", "FnB");
        responseBody.put("description", "food and beverages");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(responseBody.toString())
                .post(setAPIEndpointCreateNewCategory());
    }

    @Step("I send the request to add a new invalid category")
    public void sendRequestAddNewInvalidCategory(){
        JSONObject responseBody = new JSONObject();
        responseBody.put("name", JSONObject.NULL);
        responseBody.put("description", JSONObject.NULL);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(responseBody.toString())
                .post(setAPIEndpointCreateNewCategory());
    }

    @Step("I get status code 200 after create a new valid category")
    public void getStatus200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get status code 500 after create a new invalid category")
    public void getStatus500(){
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I got new data category that i wanted")
    public void receiveNewDataCategory(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CATEGORY_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.equalTo("FnB")));
        restAssuredThat(response -> response.body("data.Description", Matchers.equalTo("food and beverages")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
