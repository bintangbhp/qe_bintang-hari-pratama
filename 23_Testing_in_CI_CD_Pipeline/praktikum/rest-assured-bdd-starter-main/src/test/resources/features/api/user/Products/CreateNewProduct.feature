Feature: Create a new product
    As a Admin
    I want to add a new product
    So that I can updated the newest product

    # Positive
    Scenario: Create a new valid product
        Given I set the API Endpoint to create new product
        When I send the request to add a new valid product
        And I get status code 200 after create a new valid product
        Then I got new data product that i wanted to sell

    # Negative
    Scenario: Create a new invalid product
        Given I set the API Endpoint to create new product
        When I send the request to add a new invalid product
        And I get status code 500
        Then I receive error message after create an invalid product