Feature: Search something
    As a user
    I want to search for connections and content
    So that I can find relevant information and people

    Scenario: search for a connection by name
        Given I am on the dashboard page
        When I select the search bar
        And I enter the name of a connection
        And I select the "people" option
        And I click on the search button
        Then I should see a list of connections matching the name

    Scenario: search for a content by keyword
        Given I am on the dashboard page
        When I select the search bar
        And I enter a keyword
        And I select the "content" option
        And I click on the search button
        Then I should see a list of content related to the keyword

    Scenario: Search for a company by name
        Given I am on the dashboard page
        When I select the search bar
        And I enter the name of a company
        And I select the "companies" option
        And I click on the search button
        Then I should see information about the company