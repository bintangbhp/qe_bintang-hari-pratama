package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private By successMessageLoginConfirmation(){
        return By.cssSelector("span#message-id");
    }

    private By seeAllProductService(){
        return By.id("product_type_0");
    }

    private By chooseVoucherGame(){
        return By.id("Voucher Game");
    }

    @Step
    public boolean validateOnHomePage(){
        return $(successMessageLoginConfirmation()).isDisplayed();
    }

    @Step
    public boolean validateSeeAllProductService(){
        return $(seeAllProductService()).isDisplayed();
    }

    @Step
    public void clickVoucherGame(){
        $(chooseVoucherGame()).click();
    }

}
