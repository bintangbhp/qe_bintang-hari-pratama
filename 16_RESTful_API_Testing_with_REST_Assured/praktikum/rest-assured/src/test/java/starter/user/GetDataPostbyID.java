package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;
import org.hamcrest.Matchers;
import java.util.Collections;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class GetDataPostbyID {
    private static String url = "https://jsonplaceholder.typicode.com/posts/";

    @Step("I set API endpoint for post data with ID")
    public String setApiEndPoint(){
        return url + "1";
    }

    @Step("I send a request to retrieve the post data with that ID")
    public void sendDataPostRequestbyID(){
        SerenityRest.given()
                .get(setApiEndPoint());
    }

    @Step("I should receive the post data by ID")
    public void receivePostDatabyID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_DATA_POST_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("userId", equalTo(1)));
        restAssuredThat(response -> response.body("id", equalTo(1)));
        restAssuredThat(response -> response.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
        restAssuredThat(response -> response.body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for post data with an invalid ID")
    public String setApiEndPointInvalidID(){
        return url + "99999999";
    }

    @Step("I send a request to retrieve the post data with that invalid ID")
    public void sendRequestInvalidID(){
        SerenityRest.given()
                .get(setApiEndPointInvalidID());
    }

    @Step("I receive status code 404")
    public void receiveStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I should receive a empty post data")
    public void receiveNullValue(){
        restAssuredThat(response -> response.body("", equalTo(Collections.emptyMap())));
    }
}
