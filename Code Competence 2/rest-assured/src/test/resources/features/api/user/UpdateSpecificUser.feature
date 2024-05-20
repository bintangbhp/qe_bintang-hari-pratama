Feature: Update specific user data
    As a Admin
    I want to update specific user
    So that I can update a newest data for that user

    Scenario: Update specific user data with valid credentials
        Given I set the API endpoint for update a specific user data
        When I send a request for update a specific user data
        And I should receive a status code of 200
        Then I should receive newly updated data for a specific user
