package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.GetAllCartsData;

public class GetAllCartsDataSteps {
    @Steps
    GetAllCartsData getAllCartsData;

    @Given("I set the API endpoint to retrieve all carts data")
    public void setAPIEndpointAllCartsData(){
        getAllCartsData.setAPIEndpointAllCartsData();
    }

    @When("I submit a request to the API endpoint to retrieve all carts data")
    public void sendAPIEndpointAllCartsData(){
        getAllCartsData.sendAPIEndpointAllCartsData();
    }

    @Then("I should receive data for all carts data")
    public void receiveAllCartsData(){
        getAllCartsData.receiveAllCartsData();
    }
}
