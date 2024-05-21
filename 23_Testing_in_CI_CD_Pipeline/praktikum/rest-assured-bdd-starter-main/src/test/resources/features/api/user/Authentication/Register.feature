Feature: Register
    As a Guest
    I want to Register an account
    So that I can login to the application

    # Positive
    Scenario: Register a valid account
        Given I set the API Endpoint to register
        When I send the request to register a valid account
        And I get status code 200 after register a valid account
        Then I got data of my account

    # Negative
    Scenario: Register an invalid account
        Given I set the API Endpoint to register
        When I send the request to register an invalid account
        And I get status code 400 after register an invalid account
        Then I receive error message after register an invalid account