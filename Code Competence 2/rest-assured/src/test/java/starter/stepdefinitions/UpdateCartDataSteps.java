package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.UpdateCartData;

public class UpdateCartDataSteps {
    @Steps
    UpdateCartData updateCartData;

    @Given("I set the API endpoint for update a specific cart data")
    public void setAPIUpdatedCartData(){
        updateCartData.setAPIUpdatedCartData();
    }

    @When("I send a request to update cart data")
    public void sendRequestUpdateCartData(){
        updateCartData.sendRequestUpdateCartData();
    }

    @Then("I should get the data cart that I updated")
    public void receiveDataCartUpdated(){
        updateCartData.receiveDataCartUpdated();
    }
}
