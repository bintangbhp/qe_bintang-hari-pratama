Feature: Add a new user
    As a Admin
    I want to add a new user
    So that the user can using the App properly

    Scenario: Add a new user with valid data
        Given I set the API endpoint to add a new user
        When I send a request to add a new user into system
        And I should receive a status code of 200
        Then I should receive a newly added user ID