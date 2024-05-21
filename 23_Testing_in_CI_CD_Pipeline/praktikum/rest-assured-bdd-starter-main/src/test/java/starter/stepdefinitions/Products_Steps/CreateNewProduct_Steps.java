package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.CreateNewProduct;
import starter.user.Misc;

public class CreateNewProduct_Steps {
    @Steps
    CreateNewProduct createNewProduct;
    @Steps
    Misc misc;

    @Given("I set the API Endpoint to create new product")
    public void setAPIEndpointCreateNewProduct(){
        createNewProduct.setAPIEndpointCreateNewProduct();
    }

    @When("I send the request to add a new valid product")
    public void sendRequestAddNewValidProduct(){
        createNewProduct.sendRequestAddNewValidProduct();
    }

    @When("I send the request to add a new invalid product")
    public void sendRequestAddNewInvalidProduct(){
        createNewProduct.sendRequestAddNewInvalidProduct();
    }

    @And("I get status code 200 after create a new valid product")
    public void getStatus200(){
        createNewProduct.getStatus200();
    }

    @And("I get status code 500")
    public void getStatus500(){
        createNewProduct.getStatus500();
    }

    @Then("I got new data product that i wanted to sell")
    public void receiveNewDataProductWantedSell(){
        createNewProduct.receiveNewDataProductWantedSell();
    }

    @Then("I receive error message after create an invalid product")
    public void receiveErrorMessage(){
        misc.receiveErrorMessage();
    }
}
