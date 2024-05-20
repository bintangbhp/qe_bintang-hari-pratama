Feature: Get a Single Product Data
    As a user
    I want to retrieve data for a single product
    So that I can obtain specific information

    Scenario: Retrieve Single Product Data Information
        Given I set the API endpoint to retrieve single product data
        When I send a request to fetch the single product data information
        And I should receive a status code of 200
        Then I should receive the data for the single product that I have chosen

