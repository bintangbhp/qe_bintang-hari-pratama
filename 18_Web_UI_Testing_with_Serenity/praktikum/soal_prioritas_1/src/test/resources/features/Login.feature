Feature: Login
  As a user
  I want to login
  So that I can access products page

  Scenario: Login with Valid Credentials
    Given I am on the login page
    When I input valid username
    And I input valid password
    And I click login button
    Then I am on the products page
  
  Scenario: Login with Blank Fields
    Given I am on the login page
    When I click login button
    Then I should see error message "Epic sadface: Username is required"

  Scenario: Login as Locked User
    Given I am on the login page
    When I input locked username
    And I input valid password
    And I click login button
    Then I can see error message "Epic sadface: Sorry, this user has been locked out."

    Scenario: False Product Image
      Given I am on the login page
      When I input problem username
      And I input valid password
      And I click login button
      And I see products image
      Then I cannot see the real product image

