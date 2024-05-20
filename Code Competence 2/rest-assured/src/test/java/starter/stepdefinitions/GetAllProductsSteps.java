package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import starter.user.GetAllProducts;

public class GetAllProductsSteps {
    @Steps
    GetAllProducts getAllProducts;

    @Given("I set the API endpoint to retrieve all data products")
    public void setApiEndpointAllProducts(){
        getAllProducts.setApiEndpointAllProducts();
    }

    @When("I send a request to retrieve all data products")
    public void sendRequestAllProducts(){
        getAllProducts.sendRequestAllProducts();
    }

    @And("I should receive a status code of 200")
    public void receiveStatusCode200(){
        getAllProducts.receiveStatusCode200();
    }

    @Then("I should receive valid data for all products")
    public void receiveValidAllDataProducts(){
        getAllProducts.receiveValidAllDataProducts();
    }
}
