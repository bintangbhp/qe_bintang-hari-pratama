Feature: Create a user
    As a admin
    I want to create a post data
    So that the post data is stored

    Scenario: Create User with Valid Data
        Given I set API endpoint for create a post data
        When I send a request to create a post data
        Then I receive status code 201
        And I receive valid data for created post data

    Scenario: Create User with Invalid Data
        Given I set API endpoint for create a post data
        When I send a request to create a post data with unrecognized additional parameter
        Then I receive status code 400