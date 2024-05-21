package starter.stepdefinitions.Authentication_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.Login;
import starter.user.Misc;

public class Login_Steps {
    @Steps
    Login login;
    @Steps
    Misc misc;

    @Given("I set the API Endpoint to login")
    public void setAPIEndpointLogin(){
        login.setAPIEndpointLogin();
    }

    @When("I send the request to login a valid account")
    public void sendRequestLoginValidAccount(){
        login.sendRequestLoginValidAccount();
    }

    @When("I send the request to login an invalid account")
    public void sendRequestLoginInvalidAccount(){
        login.sendRequestLoginInvalidAccount();
    }

    @And("I get status code 200 after login a valid account")
    public void getStatus200(){
        login.getStatus200();
    }

    @And("I get status code 400 after login an invalid account")
    public void getStatus400(){
        login.getStatus400();
    }

    @Then("I got data of bearer token")
    public void receiveRegisteredAccountData(){
        login.receiveRegisteredAccountData();
    }

    @Then("I receive error message after login an invalid account")
    public void receiveErrorMessage(){
        misc.receiveErrorMessage();
    }
}
