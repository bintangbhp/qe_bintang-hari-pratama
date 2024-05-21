Feature: Choose Product
    As a user
    I want to choose a product
    So that I can use that product service


    Scenario: Choose Voucher Game Product
        Given I am on the landing page
        When I click sign in button on the landing page
        And I am on the login page
        And I input valid email
        And I input valid password
        And I click login button
        And I see loading system to verify
        And I see a confirmation message for successful login
        And I see all the product service
        And I click voucher game product service
        Then I am on the voucher game page