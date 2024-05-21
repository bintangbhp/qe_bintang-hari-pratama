package starter.stepdefinitions.Authentication_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.Register;
import starter.user.Misc;

public class Register_Steps {
    @Steps
    Register register;
    @Steps
    Misc misc;

    @Given("I set the API Endpoint to register")
    public void setAPIEndpointRegister(){
        register.setAPIEndpointRegister();
    }

    @When("I send the request to register a valid account")
    public void sendRequestRegisterNewValidAccount(){
        register.sendRequestRegisterNewValidAccount();
    }

    @When("I send the request to register an invalid account")
    public void sendRequestRegisterNewInvalidAccount(){
        register.sendRequestRegisterNewInvalidAccount();
    }

    @And("I get status code 200 after register a valid account")
    public void getStatus200(){
        register.getStatus200();
    }

    @And("I get status code 400 after register an invalid account")
    public void getStatus400(){
        register.getStatus400();
    }

    @Then("I got data of my account")
    public void receiveRegisteredAccountData(){
        register.receiveRegisteredAccountData();
    }

    @Then("I receive error message after register an invalid account")
    public void receiveErrorMessage(){
        misc.receiveErrorMessage();
    }
}
