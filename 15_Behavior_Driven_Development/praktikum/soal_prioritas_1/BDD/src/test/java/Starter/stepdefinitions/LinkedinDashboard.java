package Starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedinDashboard {
    @Given("I am on the dashboard page")
    public void onTheDashboardPage(){}

    @When("I select the post section")
    public void selectPostSection(){}

    @And("I write the content")
    public void writesContent(){}

    @And("I select the visibility settings")
    public void selectVisibilitySettings(){}

    @And("I click on the post button")
    public void clickPostButton(){}

    @Then("I should see the uploaded post in the feed")
    public void seeUploadedPost(){}

    @And("I click on the post button without entering any content")
    public void clickPostButtonWithoutContent(){}

    @Then("I should see an error message")
    public void seeErrorMessage(){}

    @When("I select the search bar")
    public void selectSearchBar(){}

    @And("I enter the name of a connection")
    public void enterNameConnection(){}

    @And("I select the \"people\" option")
    public void selectPeopleOption(){}

    @And("I click on the search button")
    public void clickSearchButton(){}

    @Then("I should see a list of connections matching the name")
    public void seeListConnection(){}

    @And("I enter a keyword")
    public void enterKeyword(){}

    @And("I select the \"content\" option")
    public void selectContentOption(){}

    @Then("I should see a list of content related to the keyword")
    public void seeListContentRelatedKeyword(){}

    @And("I enter the name of a company")
    public void enterCompanyName() {}

    @And("I select the \"companies\" option")
    public void selectCompaniesOption(){}

    @Then("I should see information about the company")
    public void seeCompanyInformation() {}

    @And("I am viewing a post")
    public void viewPost() {}

    @And("I click on the \"comment\" button")
    public void clickCommentButton(){}

    @And("I write a comment")
    public void writeComment() {}

    @Then("I should see my comment added to the post")
    public void seeCommentAdded() {}

    @And("I click on the \"like\" button")
    public void clickLikeButton(){}

    @Then("I should see the post liked")
    public void seePostLiked() {}

    @And("I click on the \"share\" button")
    public void clickShareButton(){}

    @And("I select the sharing options")
    public void selectSharingOptions() {}

    @And("I click on the \"share\" button again")
    public void clickShareButtonAgain(){}

    @Then("I should see a confirmation message")
    public void seeConfirmationMessage() {}

    @And("The post should be shared with the selected audience")
    public void postSharedWithAudience() {}
}
