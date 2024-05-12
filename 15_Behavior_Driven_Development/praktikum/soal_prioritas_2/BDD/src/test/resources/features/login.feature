Feature: Login to Sepulsa Application
    As a user
    I want to login
    so that I can access online services

    Scenario: Login with valid credentials
        Given I am on the dashboard page
        When I click the "login" button
        Then I should be on the login page
        And I fill in the email and password fields with valid credentials
        And I click the "login" button again
        Then I should see a confirmation pop-up for successful login

    Scenario: Login with invalid email
        Given I am on the login page
        When I fill in the email field with an invalid email and valid password
        And I click the "login" button
        Then I should see an error message indicating invalid email

    Scenario: Login with incorrect password
        Given I am on the login page
        When I fill in the email field with a valid email and invalid password
        And I click the "login" button
        Then I should see an error message indicating invalid password

    Scenario: Login with forgot password feature
        Given I am on the login page
        When I click "forgot password" link
        And I fill in the email field with a valid email for password recovery
        And I click the "send" button
        Then I should receive an email with instructions for password recovery