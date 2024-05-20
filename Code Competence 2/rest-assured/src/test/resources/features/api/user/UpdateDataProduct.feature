Feature: Updating Product in Cart
    As a user,
    I want to be able to update product data
    So that the product information is kept current.

    Scenario: Updating Product in Cart with Valid Inputs
        Given I set the API endpoint to update product data
        When I submit a request to update product data with valid credentials
        And I should receive a status code of 200
        Then I should receive valid data confirming the updated product information