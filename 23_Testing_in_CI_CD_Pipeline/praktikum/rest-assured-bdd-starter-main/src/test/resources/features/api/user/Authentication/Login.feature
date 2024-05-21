Feature: Login
    As a Guest
    I want to Login
    So that I can use some feature

    # Positive
    Scenario: Login a valid account
        Given I set the API Endpoint to login
        When I send the request to login a valid account
        And I get status code 200 after login a valid account
        Then I got data of bearer token

    # Negative
    Scenario: Login an invalid account
        Given I set the API Endpoint to login
        When I send the request to login an invalid account
        And I get status code 400 after login an invalid account
        Then I receive error message after login an invalid account