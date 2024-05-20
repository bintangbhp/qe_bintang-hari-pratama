package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.AddNewCart;

public class AddNewCartSteps {
    @Steps
    AddNewCart addNewCart;

    @Given("I set the API endpoint for add a product to cart")
    public void setAPIEndpointAddNewCart(){
        addNewCart.setAPIEndpointAddNewCart();
    }

    @When("I submit a request to add a product to cart")
    public void sendRequestAddNewCart(){
        addNewCart.sendRequestAddNewCart();
    }

    @Then("I should receive confirmation that the product has been successfully added to cart")
    public void receiveNewCartData(){
        addNewCart.receiveNewCartData();
    }
}
