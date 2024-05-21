package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.GetAllProducts;
import starter.user.Misc;

public class GetAllProducts_Steps {
    @Steps
    GetAllProducts getAllProducts;
    @Steps
    Misc misc;

    @Given("I set the API Endpoint to get all products")
    public void setAPIEndpointGetAllProducts(){
        getAllProducts.setAPIEndpointGetAllProducts();
    }

    @When("I send the request to get all products")
    public void sendRequestGetAllProducts(){
        getAllProducts.sendRequestGetAllProducts();
    }

    @And("I get status code 200 after request to get all product")
    public void getStatus200(){
        getAllProducts.getStatus200();
    }

    @Then("I receive all data products")
    public void receiveAllDataProducts(){
        getAllProducts.receiveAllDataProducts();
    }

    //NEGATIF
    @When("I send the request to get all products with invalid method")
    public void sendRequestInvalidMethod(){
        getAllProducts.sendRequestInvalidMethod();
    }

    @And("I get status code 400")
    public void getStatus400(){
        getAllProducts.getStatus400();
    }

    @Then("I receive error message after request all product")
    public void receiveErrorMessage(){
        misc.receiveErrorMessage();
    }
}
