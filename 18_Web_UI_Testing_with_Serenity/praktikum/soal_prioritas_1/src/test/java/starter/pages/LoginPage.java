package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private By usernameField(){
        return By.id("user-name");
    }

    private By passwordField(){
        return By.id("password");
    }

    private By loginButton(){
        return By.id("login-button");
    }

    private By errorMessage(){
        return By.xpath("//h3[@data-test='error']");
    }

    @Step
    public boolean validationOnLoginPage(){
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void inputUsername(String username){
        $(usernameField()).type(username);
    }

    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }

    @Step
    public boolean validateErrorMessageIsDisplayed(){
        return $(errorMessage()).isDisplayed();
    }

    @Step
    public boolean validationEqualErrorMessage(String message){
        return $(errorMessage()).getText().equalsIgnoreCase(message);
    }

}
