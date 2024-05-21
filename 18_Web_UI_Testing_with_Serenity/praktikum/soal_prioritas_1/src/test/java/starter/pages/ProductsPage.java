package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductsPage extends PageObject {
    private By title(){
        return By.className("app_logo");
    }

    private By productImage(){
        return By.className("inventory_item_img");
    }

    private By falseProductImage(){
        return By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']");
    }

    @Step
    public boolean validateOnProductPage(){
        return $(title()).isDisplayed();
    }

    @Step
    public boolean validationProductImageIsDisplayed(){
        return $(productImage()).isDisplayed();
    }

    @Step
    public boolean falseProductIsDisplayed(){
        return $(falseProductImage()).isDisplayed();
    }


}
