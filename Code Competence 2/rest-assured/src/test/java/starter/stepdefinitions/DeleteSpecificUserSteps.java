package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.DeleteSpecificUser;

public class DeleteSpecificUserSteps {
    @Steps
    DeleteSpecificUser deleteSpecificUser;

    @Given("I set the API endpoint to delete a specific user")
    public void setAPIEndpointDeleteSpecificUser(){
        deleteSpecificUser.setAPIEndpointDeleteSpecificUser();
    }

    @When("I send a request to delete a specific user")
    public void sendRequestDeleteSpecificUser(){
        deleteSpecificUser.sendRequestDeleteSpecificUser();
    }

    @Then("I should receive data for the user that has been deleted")
    public void receiveDeletedData(){
        deleteSpecificUser.receiveDeletedData();
    }
}
