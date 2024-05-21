package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import starter.user.PutDataPostbyID;

public class PutDataPostbyIDSteps {
    @Steps
    static PutDataPostbyID putDataPostbyID;

    @When("I send a PUT request to update the post data with that ID")
    public void putPostDataUpdate(){
        putDataPostbyID.putPostDataUpdate();
    }

    @Then("The post data should be updated successfully")
    public void postDataUpdated(){
        putDataPostbyID.postDataUpdated();
    }

    @When("I send a PUT request to update the post data with that invalid ID")
    public void sendRequestUpdateInvalidID(){
        putDataPostbyID.sendRequestUpdateInvalidID();
    }

    @And("I should receive a message indicating that the post with the given ID does not exist")
    public void receiveErrorMessage(){
        putDataPostbyID.receiveErrorMessage();
    }

}
