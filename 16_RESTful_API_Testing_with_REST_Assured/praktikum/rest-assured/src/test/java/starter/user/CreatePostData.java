package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class CreatePostData {
    private static String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set API endpoint for create a post data")
    public String setApiEndPoint(){
        return url + "posts";
    }

    @Step("I send a request to create a post data")
    public void sendDataPostRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "foo" );
        requestBody.put("body", "bar");
        requestBody.put("id", 101);
        requestBody.put("userId", 1);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndPoint());
    }

    @Step("I receive status code 201")
    public void receiveStatusCode201(){
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid data for created post data")
    public void receiveCreatedPostData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_POST_DATA_SCHEMA);

        restAssuredThat(response -> response.body("'title'", equalTo("foo")));
        restAssuredThat(response -> response.body("'body'", equalTo("bar")));
        restAssuredThat(response -> response.body("'id'", equalTo(101)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a request to create a post data with unrecognized additional parameter")
    public void sendUnrecognizedParameter(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", JSONObject.NULL );
        requestBody.put("body", JSONObject.NULL);
        requestBody.put("id", JSONObject.NULL);
        requestBody.put("userId", JSONObject.NULL);
        requestBody.put("add_param", JSONObject.NULL);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndPoint());
    }

    @Step("I receive valid parameter for created post data")
    public void receiveValidParameter(){
        restAssuredThat(response -> response.body("'title'", notNullValue()));
        restAssuredThat(response -> response.body("'body'", notNullValue()));
        restAssuredThat(response -> response.body("'id'", notNullValue()));
        restAssuredThat(response -> response.body("'userId'", notNullValue()));
    }
}
