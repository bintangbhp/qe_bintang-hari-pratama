package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.LoginPage;
import starter.pages.ProductsPage;

public class LoginSteps {
    @Steps
    LoginPage loginPage;

    @Steps
    ProductsPage productsPage;

    @Given("I am on the login page")
    public void onTheLoginPage(){
        loginPage.openUrl("https://www.saucedemo.com/");
        Assertions.assertTrue(loginPage.validationOnLoginPage());
    }

    @When("I input valid username")
    public void inputValidUsername(){
        loginPage.inputUsername("standard_user");
    }

    @And("I input valid password")
    public void inputValidPassword(){
        loginPage.inputPassword("secret_sauce");
    }

    @And("I click login button")
    public void clickLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("I am on the products page")
    public void onTheProductsPage(){
        Assertions.assertTrue(productsPage.validateOnProductPage());
    }

    @When("I input locked username")
    public void inputLockedUsername(){
        loginPage.inputUsername("locked_out_user");
    }

    @Then("I can see error message {string}")
    public void validateErrorMessageIsDisplayed(String message){
        Assertions.assertTrue(loginPage.validateErrorMessageIsDisplayed());
        Assertions.assertTrue(loginPage.validationEqualErrorMessage(message));
    }

    @When("I input problem username")
    public void inputProblemUsername(){
        loginPage.inputUsername("problem_user");
    }

    @And("I see products image")
    public void seeProductsImage(){
        Assertions.assertTrue(productsPage.validateOnProductPage());
        Assertions.assertTrue(productsPage.validationProductImageIsDisplayed());
    }

    @Then("I cannot see the real product image")
    public void CannotSeeTheRealProductImage(){
        Assertions.assertTrue(productsPage.validationProductImageIsDisplayed());
        Assertions.assertTrue(productsPage.validateOnProductPage());
        Assertions.assertTrue(productsPage.falseProductIsDisplayed());
    }

    @Then("I should see error message {string}")
    public void ErrorMessageForBlankFields(String message){
        Assertions.assertTrue(loginPage.validateErrorMessageIsDisplayed());
        Assertions.assertTrue(loginPage.validationEqualErrorMessage(message));
    }
}