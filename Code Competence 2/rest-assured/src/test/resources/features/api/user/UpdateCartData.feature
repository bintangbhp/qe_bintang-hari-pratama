Feature: Update cart data
    As a User
    I want to update cart data
    So that I can update information for specific items in my cart

    Scenario: Update Cart Data
        Given I set the API endpoint for update a specific cart data
        When I send a request to update cart data
        And I should receive a status code of 200
        Then I should get the data cart that I updated