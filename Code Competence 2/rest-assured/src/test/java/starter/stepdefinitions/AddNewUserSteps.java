package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.AddNewUser;

public class AddNewUserSteps {
    @Steps
    AddNewUser addNewUser;

    @Given("I set the API endpoint to add a new user")
    public void setAPIEndpointAddNewUser(){
        addNewUser.setAPIEndpointAddNewUser();
    }

    @When("I send a request to add a new user into system")
    public void sendRequestAddNewUser(){
        addNewUser.sendRequestAddNewUser();
    }

    @Then("I should receive a newly added user ID")
    public void receiveUserID(){
        addNewUser.receiveUserID();
    }
}
