package starter.user;

import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Misc {
    @Step("I receive error message")
    public void receiveErrorMessage(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ERROR_SCHEMA);

        restAssuredThat(response -> response.body("error", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
