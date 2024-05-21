package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

import starter.user.GetDataPostbyID;

public class PutDataPostbyID {
    private static String url = "https://jsonplaceholder.typicode.com/posts/";

    @Step("I set API endpoint for post data with ID")
    public String setApiEndPoint(){
        return url + "1";
    }

    @Step("I send a PUT request to update the post data with that ID")
    public void putPostDataUpdate(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("title", "foo" );
        requestBody.put("body", "bar");
        requestBody.put("userId", 1);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setApiEndPoint());
    }

    @Step("The post data should be updated successfully")
    public void postDataUpdated(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.PUT_DATA_POST_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("'id'", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("'title'", Matchers.equalTo("foo")));
        restAssuredThat(response -> response.body("'body'", Matchers.equalTo("bar")));
        restAssuredThat(response -> response.body("'userId'", Matchers.equalTo(1)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a PUT request to update the post data with that invalid ID")
    public void sendRequestUpdateInvalidID(){
        GetDataPostbyID getDataPostbyID = new GetDataPostbyID();
        SerenityRest.given()
                .get(getDataPostbyID.setApiEndPointInvalidID());
    }

    @Step("I should receive a message indicating that the post with the given ID does not exist")
    public void receiveErrorMessage(){
        restAssuredThat(response -> response.body("'error'", Matchers.nullValue()));
    }

}
