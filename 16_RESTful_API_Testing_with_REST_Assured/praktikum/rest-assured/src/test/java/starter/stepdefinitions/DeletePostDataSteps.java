package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.DeletePostData;

public class DeletePostDataSteps {
    @Steps
    DeletePostData deletePostData;

    @Given("I set API endpoint for delete post data with ID")
    public void setDeleteApiEndPoint(){
        deletePostData.setDeleteApiEndPoint();
    }

    @When("I send a request to delete a post data with ID")
    public void sendDeletePostDataRequest(){
        deletePostData.sendDeletePostDataRequest();
    }

    @Then("I receive status code 204")
    public void receiveStatusCode204(){
        deletePostData.receiveStatusCode204();
    }

}
