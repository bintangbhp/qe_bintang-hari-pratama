package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
public class DeletePostData {
    private static String url = "https://jsonplaceholder.typicode.com/posts/";

    @Step("I set API endpoint for delete post data with ID")
    public String setDeleteApiEndPoint(){
        return url + "1";
    }

    @Step("I send a request to delete a post data with ID")
    public void sendDeletePostDataRequest(){
        SerenityRest.given()
                .delete(setDeleteApiEndPoint());
    }

    @Step("I receive status code 204")
    public void receiveStatusCode204(){
        restAssuredThat(response -> response.statusCode(204));
    }
}
