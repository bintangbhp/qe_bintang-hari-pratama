Feature: Get product category by Id
    As a User
    I want to get product category by Id
    So that I can choose the category that I wanted to buy

    # Positive
    Scenario: Get product category by valid Id
        Given I set the API Endpoint to get product category
        When I send the request to get product category by valid Id
        And I get status code 200 after request to get product category by valid Id
        Then I receive product category

    # Negative
    Scenario: Get product category by invalid Id
        Given I set the API Endpoint to get product category
        When I send the request to get product category by invalid Id
        And I get status code 404
        Then I receive error message after request to get product category by invalid Id