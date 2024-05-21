Feature: Create a new category
    As a Admin
    I want to add a new category
    So that I can updated the newest category

    # Positive
    Scenario: Create a new valid category
        Given I set the API Endpoint to create new category
        When I send the request to add a new valid category
        And I get status code 200 after create a new valid category
        Then I got new data category that i wanted

    # Negative
    Scenario: Create a new invalid category
        Given I set the API Endpoint to create new category
        When I send the request to add a new invalid category
        And I get status code 500 after create a new invalid category
        Then I receive error message after create an invalid category