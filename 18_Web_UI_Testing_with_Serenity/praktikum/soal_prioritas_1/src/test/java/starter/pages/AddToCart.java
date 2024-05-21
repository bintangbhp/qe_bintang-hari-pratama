package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class AddToCart extends PageObject {

    private By productDescriptions(){
        return By.className("inventory_item_description");
    }

    private By addToCartButton(){
        return By.id("add-to-cart-sauce-labs-bike-light");
    }

    private By cartButton(){
        return  By.className("shopping_cart_link");
    }

    @Step
    public boolean validationProductDescriptions(){
        return $(productDescriptions()).isDisplayed();
    }

    @Step
    public void clickAddToCartButton(){
        $(addToCartButton()).click();
    }

    @Step
    public void clickCartButton(){
        $(cartButton()).click();
    }


}
