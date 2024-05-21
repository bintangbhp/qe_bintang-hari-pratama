package starter.stepdefinitions.ProductCategories_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.ProductCategories.CreateNewCategory;
import starter.user.Misc;

public class CreateNewCategory_Steps {
    @Steps
    CreateNewCategory createNewCategory;
    @Steps
    Misc misc;

    @Given("I set the API Endpoint to create new category")
    public void setAPIEndpointCreateNewCategory(){
        createNewCategory.setAPIEndpointCreateNewCategory();
    }

    @When("I send the request to add a new valid category")
    public void sendRequestAddNewValidProduct(){
        createNewCategory.sendRequestAddNewValidCategory();
    }

    @When("I send the request to add a new invalid category")
    public void sendRequestAddNewInvalidProduct(){
        createNewCategory.sendRequestAddNewInvalidCategory();
    }

    @And("I get status code 200 after create a new valid category")
    public void getStatus200(){
        createNewCategory.getStatus200();
    }

    @And("I get status code 500 after create a new invalid category")
    public void getStatus500(){
        createNewCategory.getStatus500();
    }

    @Then("I got new data category that i wanted")
    public void receiveNewDataCategory(){
        createNewCategory.receiveNewDataCategory();
    }

    @Then("I receive error message after create an invalid category")
    public void receiveErrorMessage(){
        misc.receiveErrorMessage();
    }
}
