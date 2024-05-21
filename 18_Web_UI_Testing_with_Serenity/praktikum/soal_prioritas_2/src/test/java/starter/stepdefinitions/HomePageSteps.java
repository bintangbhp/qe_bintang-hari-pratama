package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.HomePage;
import starter.pages.VoucherGamePage;


public class HomePageSteps {
    @Steps
    HomePage homePage;

    @Steps
    VoucherGamePage voucherGamePage;

    @And("I see all the product service")
    public void seeAllProductService(){
        Assertions.assertTrue(homePage.validateSeeAllProductService());
    }

    @And("I click voucher game product service")
    public void clickVoucherGame(){
        homePage.clickVoucherGame();
    }

    @Then("I am on the voucher game page")
    public void inTheVoucherGamePage(){
        Assertions.assertTrue(voucherGamePage.validateInVoucherGamePage());
    }

}
