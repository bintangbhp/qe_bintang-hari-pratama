Feature: Interaction with posts
    As a User
    I want to be able to interact with posts
    So that I can engage with the content shared on Linkedin

    Scenario: Comment on a post
        Given I am on the dashboard page
        And I am viewing a post
        And I click on the "comment" button
        And I write a comment
        Then I should see my comment added to the post

    Scenario: Like a post
        Given I am on the dashboard page
        And I am viewing a post
        And I click on the "like" button
        Then I should see the post liked

    Scenario: Share a post
        Given I am on the dashboard page
        And I am viewing a post
        And I click on the "share" button
        And I select the sharing options
        And I click on the "share" button again
        Then I should see a confirmation message
        And The post should be shared with the selected audience