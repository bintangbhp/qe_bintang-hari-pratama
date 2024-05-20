package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.UpdateSpecificUser;

public class UpdateSpecificUserSteps {
    @Steps
    UpdateSpecificUser updateSpecificUser;

    @Given("I set the API endpoint for update a specific user data")
    public void setAPIEndpointUpdateUserData(){
        updateSpecificUser.setAPIEndpointUpdateUserData();
    }

    @When("I send a request for update a specific user data")
    public void sendRequestUpdateUserData(){
        updateSpecificUser.sendRequestUpdateUserData();
    }

    @Then("I should receive newly updated data for a specific user")
    public void receiveUpdatedData(){
        updateSpecificUser.receiveUpdatedData();
    }
}
