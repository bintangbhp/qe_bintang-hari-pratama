package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.UpdateDataProduct;

public class UpdateDataProductSteps{
    @Steps
    UpdateDataProduct updateDataProduct;

    @Given("I set the API endpoint to update product data")
    public void setApiEndpointUpdateData(){
        updateDataProduct.setApiEndpointUpdateData();
    }

    @When("I submit a request to update product data with valid credentials")
    public void sendRequestUpdateData(){
        updateDataProduct.sendRequestUpdateData();
    }

    @Then("I should receive valid data confirming the updated product information")
    public void receiveUpdatedProductData(){
        updateDataProduct.receiveUpdatedProductData();
    }
}
