package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.GetAllPostData;

public class GetAllPostDataSteps {
    @Steps
    GetAllPostData getAllPostData;

    @Given("I set API endpoint for get all post data")
    public void setApiEndPoint(){
        getAllPostData.setApiEndPoint();
    }

    @When("I send a request to get all post data")
    public void sendGetAllPostData(){
        getAllPostData.sendGetAllPostData();
    }

    @Then("I receive status code 200")
    public void receiveStatusCode200(){
        getAllPostData.receiveStatusCode200();
    }

    @And("I receive valid data for all post data")
        public void receiveValidAllPostData(){
            getAllPostData.receiveValidAllPostData();
        }

    @Then("I receive status code 400")
    public void receiveStatusCode400(){
        getAllPostData.receiveStatusCode400();
    }

    @And("I receive null data for all post data")
    public void receiveNullData(){
        getAllPostData.receiveNullData();
    }
}
