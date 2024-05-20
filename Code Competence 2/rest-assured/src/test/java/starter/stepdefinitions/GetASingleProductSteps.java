package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.GetASingleProduct;

public class GetASingleProductSteps {
    @Steps
    GetASingleProduct getASingleProduct;

    @Given("I set the API endpoint to retrieve single product data")
    public void setApiEndpointSingleProduct(){
        getASingleProduct.setApiEndpointSingleProduct();
    }

    @When("I send a request to fetch the single product data information")
    public void sendRequestSingleProduct(){
        getASingleProduct.sendRequestSingleProduct();
    }

    @Then("I should receive the data for the single product that I have chosen")
    public void receiveSingleDataProduct(){
        getASingleProduct.receiveSingleDataProduct();
    }
}
