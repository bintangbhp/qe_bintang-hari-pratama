Feature: Get all Products
    As a User
    I want to get all products
    So that I can choose the products that I wanted to buy

    # Positive
    Scenario: Get all valid data products
        Given I set the API Endpoint to get all products
        When I send the request to get all products
        And I get status code 200 after request to get all product
        Then I receive all data products

    # Negative
    Scenario: Get all data product with invalid method
        Given I set the API Endpoint to get all products
        When I send the request to get all products with invalid method
        And I get status code 400
        Then I receive error message after request all product