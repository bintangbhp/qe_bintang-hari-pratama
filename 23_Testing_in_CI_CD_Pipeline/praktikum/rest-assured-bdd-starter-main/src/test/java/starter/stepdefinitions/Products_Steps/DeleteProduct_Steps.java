package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.DeleteProduct;
import starter.user.Misc;

public class DeleteProduct_Steps {
    @Steps
    DeleteProduct deleteProduct;
    @Steps
    Misc misc;

    @Given("I set API endpoint for delete product")
    public void setAPIEndpointDeleteProduct(){
        deleteProduct.setAPIEndpointDeleteProduct();
    }

    @When("I send a request to delete a valid product")
    public void sendDeleteValidProductRequest() {
        deleteProduct.sendDeleteValidProductRequest();
    }

    @When("I send a request to delete an invalid product")
    public void sendDeleteInvalidProductRequest() {
        deleteProduct.sendDeleteInvalidProductRequest();
    }

    @And("I get status code 200 after request to delete a valid product")
    public void getStatus200(){
        deleteProduct.getStatus200();
    }

    @And("I get status code 500 after request to delete an invalid product")
    public void getStatus500(){
        deleteProduct.getStatus500();
    }

    @Then("I get a successfull message")
    public void getSuccessfullMessage(){
        deleteProduct.getSuccessfullMessage();
    }

    @Then("I receive error after request to delete an invalid product")
    public void receiveErrorMessage(){
        misc.receiveErrorMessage();
    }
}
