Feature: Delete a user
    As a Admin
    I want to delete a specific user
    So that I can maintain whether the user is still active or not

    Scenario: Delete user with Specific ID
        Given I set the API endpoint to delete a specific user
        When I send a request to delete a specific user
        And I should receive a status code of 200
        Then I should receive data for the user that has been deleted