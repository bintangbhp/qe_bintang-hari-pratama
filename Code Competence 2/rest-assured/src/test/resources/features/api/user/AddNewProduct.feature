Feature: Add a new product
    As a User
    I want to be able to add a new product
    So that I can ensure the product data is securely saved

    Scenario: Add a new product with valid inputs
        Given I set the API endpoint for adding a new product
        When I submit a request to add a new product with valid credentials
        And I should receive a status code of 200
        Then I should receive confirmation that the new product has been successfully added