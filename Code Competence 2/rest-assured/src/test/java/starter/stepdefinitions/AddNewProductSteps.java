package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.AddNewProduct;

public class AddNewProductSteps {
    @Steps
    AddNewProduct addNewProduct;

    @Given("I set the API endpoint for adding a new product")
    public void setAPIAddNewProduct(){
        addNewProduct.setAPIAddNewProduct();
    }

    @When("I submit a request to add a new product with valid credentials")
    public void sendRequestAddNeqProduct(){
        addNewProduct.sendRequestAddNeqProduct();
    }

    @Then("I should receive confirmation that the new product has been successfully added")
    public void receiveNewProductData(){
        addNewProduct.receiveNewProductData();
    }
}
