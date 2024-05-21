package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import starter.user.GetDataPostbyID;

public class GetDataPostbyIDSteps {
    @Steps
    static GetDataPostbyID getDataPostbyID;

    @Given("I set API endpoint for post data with ID")
    public void setApiEndPoint(){
        getDataPostbyID.setApiEndPoint();
    }

    @When("I send a request to retrieve the post data with that ID")
    public void sendDataPostRequestbyID(){
        getDataPostbyID.sendDataPostRequestbyID();
    }

    @Then("I should receive the post data by ID")
    public void receivePostDatabyID(){
        getDataPostbyID.receivePostDatabyID();
    }

    @Given("I set API endpoint for post data with an invalid ID")
    public void setApiEndPointInvalidID(){
        getDataPostbyID.setApiEndPointInvalidID();
    }

    @When("I send a request to retrieve the post data with that invalid ID")
    public void sendRequestInvalidID(){
        getDataPostbyID.sendRequestInvalidID();
    }

    @Then("I receive status code 404")
    public void receiveStatusCode404(){
        getDataPostbyID.receiveStatusCode404();
    }

    @And("I should receive a empty post data")
    public void receiveNullValue(){
        getDataPostbyID.receiveNullValue();
    }
}
