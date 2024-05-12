package Starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SepulsaBDDTesting {
    @Given("I am on the dashboard page")
    public void onDashboardPage(){}

    @When("I click the \"login\" button")
    public void clickLoginButton(){}

    @Then("I should be on the login page")
    public void shouldBeOnLoginPage(){}

    @And("I fill in the email and password fields with valid credentials")
    public void fillEmailAndPasswordWithValidCredentials(){}

    @And("I click the \"login\" button again")
    public void clickLoginButtonAgain(){}

    @Then("I should see a confirmation pop-up for successful login")
    public void seeConfirmationPopup(){}

    @Given("I am on the login page")
    public void onLoginPage(){}

    @When("I fill in the email field with an invalid email and valid password")
    public void fillInvalidEmailAndValidPassword(){}

    @Then("I should see an error message indicating invalid email")
    public void seeInvalidEmailErrorMessage(){}

    @When("I fill in the email field with a valid email and invalid password")
    public void fillValidEmailAndInvalidPassword(){}

    @Then("I should see an error message indicating invalid password")
    public void seeInvalidPasswordErrorMessage(){}

    @When("I click \"forgot password\" link")
    public void clickForgotPasswordLink(){}

    @And("I fill in the email field with a valid email for password recovery")
    public void fillEmailForPasswordRecovery(){}

    @And("I click the \"send\" button")
    public void clickSendButton(){}

    @Then("I should receive an email with instructions for password recovery")
    public void receiveEmailInstructionsForPasswordRecovery(){}

    @Given("I am on the product selection page")
    public void onProductSelectionPage(){}

    @When("I select the \"Pulsa\" product")
    public void selectPulsaProduct(){}

    @Then("I should see options for different pulsa denominations")
    public void seePulsaDenominations(){}

    @When("I select the \"Voucher Game\" product")
    public void selectVoucherGameProduct(){}

    @Then("I should see options for different voucher game denominations")
    public void seeVoucherGameDenominations(){}

    @When("I select the \"e-money\" product")
    public void selectEMoneyProduct(){}

    @Then("I should see options for different e-money services")
    public void seeEMoneyServices(){}

    @When("I select the \"other product\" product")
    public void selectOtherProduct(){}

    @Then("I should see all sepulsa's products")
    public void seeAllSepulsaProducts(){}

    @Given("I am on the payment method selection page")
    public void onPaymentMethodSelectionPage(){}

    @When("I enter my phone number")
    public void enterPhoneNumber(){}

    @Then("I should see the available pulsa packages")
    public void seeAvailablePulsaPackages(){}

    @And("I choose a specific pulsa denomination")
    public void chooseSpecificPulsaDenomination(){}

    @And("I proceed to the payment page")
    public void proceedToPaymentPage(){}

    @Then("I should see options to select a payment method")
    public void seeOptionsToSelectPaymentMethod(){}

    @And("I choose \"Gopay\" as the payment method")
    public void chooseGopayPaymentMethod(){}

    @Given("I am on the payment page")
    public void onPaymentPage(){}

    @When("I review my payment options")
    public void reviewPaymentOptions(){}

    @Then("I should see various payment methods available")
    public void seeVariousPaymentMethodsAvailable(){}

    @And("I choose \"Bank Transfer\" as the payment method")
    public void chooseBankTransferPaymentMethod(){}

}
