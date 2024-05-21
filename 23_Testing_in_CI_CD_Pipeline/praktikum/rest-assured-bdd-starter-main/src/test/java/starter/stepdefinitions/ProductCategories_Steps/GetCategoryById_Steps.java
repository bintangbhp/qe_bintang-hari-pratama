package starter.stepdefinitions.ProductCategories_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.ProductCategories.GetCategoryById;
import starter.user.Misc;

public class GetCategoryById_Steps {
    @Steps
    GetCategoryById getCategoryById;
    @Steps
    Misc misc;

    @Given("I set the API Endpoint to get product category")
    public void setAPIEndpointGetCategory(){
        getCategoryById.setAPIEndpointGetCategory();
    }

    @When("I send the request to get product category by valid Id")
    public void sendGetValidCategoryRequest() {
        getCategoryById.sendGetValidCategoryRequest();
    }

    @When("I send the request to get product category by invalid Id")
    public void sendGetInvalidCategoryRequest() {
        getCategoryById.sendGetInvalidCategoryRequest();
    }

    @And("I get status code 200 after request to get product category by valid Id")
    public void getStatus200(){
        getCategoryById.getStatus200();
    }

    @And("I get status code 404")
    public void getStatus404(){
        getCategoryById.getStatus404();
    }

    @Then("I receive product category")
    public void receiveAllDataCategory(){
        getCategoryById.receiveAllDataCategory();
    }

    @Then("I receive error message after request to get product category by invalid Id")
    public void receiveErrorMessage(){
        misc.receiveErrorMessage();
    }

}
