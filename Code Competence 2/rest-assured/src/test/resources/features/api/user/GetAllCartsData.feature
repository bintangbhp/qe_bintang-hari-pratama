Feature: Get all carts data
    As a User
    I want to get all carts data
    So that I can view list all the cart data information

    Scenario: Get All Carts
        Given I set the API endpoint to retrieve all carts data
        When I submit a request to the API endpoint to retrieve all carts data
        And I should receive a status code of 200
        Then I should receive data for all carts data