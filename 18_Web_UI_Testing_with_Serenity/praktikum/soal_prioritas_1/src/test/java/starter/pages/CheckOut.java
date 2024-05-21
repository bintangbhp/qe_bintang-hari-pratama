package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CheckOut extends PageObject {
    private static By checkOutButton(){
        return By.id("checkout");
    }

    @Step
    public boolean validationOnCartPage(){
        return $(checkOutButton()).isDisplayed();
    }
}
