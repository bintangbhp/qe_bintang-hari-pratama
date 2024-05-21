package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.CreatePostData;

public class CreatePostDataSteps {
    @Steps
    static CreatePostData createPostData;

    @Given("I set API endpoint for create a post data")
    public void setApiEndPoint(){
        createPostData.setApiEndPoint();
    }

    @When("I send a request to create a post data")
    public void sendDataPostRequest(){
        createPostData.sendDataPostRequest();
    }

    @Then("I receive status code 201")
    public void receiveStatusCode201(){
        createPostData.receiveStatusCode201();
    }

    @And("I receive valid data for created post data")
    public void receiveCreatedPostData(){
        createPostData.receiveCreatedPostData();
    }

    @When("I send a request to create a post data with unrecognized additional parameter")
    public void sendUnrecognizedParameter(){
        createPostData.sendUnrecognizedParameter();
    }

    @And("I receive valid parameter for created post data")
    public void receiveValidParameter(){
        createPostData.receiveValidParameter();
    }
}
