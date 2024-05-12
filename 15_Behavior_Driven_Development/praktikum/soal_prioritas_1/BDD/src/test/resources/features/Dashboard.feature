Feature: Create a post
  As a user
  I want to create a post
  so that I can share content with my network

  Scenario: Create a post with valid credentials
    Given I am on the dashboard page
    When I select the post section
    And I write the content
    And I select the visibility settings
    And I click on the post button
    Then I should see the uploaded post in the feed

  Scenario: Unable to create a post without content
    Given I am on the dashboard page
    When I select the post section
    And I click on the post button without entering any content
    Then I should see an error message




