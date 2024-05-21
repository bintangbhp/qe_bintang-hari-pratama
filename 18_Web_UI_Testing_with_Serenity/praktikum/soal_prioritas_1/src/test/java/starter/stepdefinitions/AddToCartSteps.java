package starter.stepdefinitions;

import net.serenitybdd.annotations.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import starter.pages.AddToCart;
import starter.pages.CheckOut;

public class AddToCartSteps {
    @Steps
    AddToCart addToCart;

    @Steps
    CheckOut checkOut;

    @And("I see products description")
    public void seeProductDescription() {
        Assertions.assertTrue(addToCart.validationProductDescriptions());
    }

    @And("I click add to cart button")
    public void AddToCartButton(){
        addToCart.clickAddToCartButton();
    }

    @And("I click cart button")
    public void clickCartButton(){
        addToCart.clickCartButton();
    }

    @Then("I can see my product in cart page")
    public void seeProductInCartPage(){
        Assertions.assertTrue(checkOut.validationOnCartPage());
    }
}
