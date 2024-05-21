package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class VoucherGamePage extends PageObject {
    private By voucherGameTitle(){
        return By.xpath("//*[@id=\"__next\"]/div/div[1]/header/div/div[2]/h1");
    }

    public boolean validateInVoucherGamePage(){
        return $(voucherGameTitle()).isDisplayed();
    }
}
