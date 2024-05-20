Feature: Add a product to cart
    As a User
    I want to add a product to my cart
    So that I can proceed with the payment process

    Scenario: Add Product
        Given I set the API endpoint for add a product to cart
        When I submit a request to add a product to cart
        And I should receive a status code of 200
        Then I should receive confirmation that the product has been successfully added to cart