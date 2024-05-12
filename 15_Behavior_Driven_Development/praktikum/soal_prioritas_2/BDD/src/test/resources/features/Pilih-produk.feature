Feature: Select product
  As a user
  I want to select a product
  so that I can make a purchase

  Scenario: Selecting pulsa product
    Given I am on the product selection page
    When I select the "Pulsa" product
    Then I should see options for different pulsa denominations

  Scenario: Selecting voucher game product
    Given I am on the product selection page
    When I select the "Voucher Game" product
    Then I should see options for different voucher game denominations

  Scenario: Selecting e-money product
    Given I am on the product selection page
    When I select the "e-money" product
    Then I should see options for different e-money services

  Scenario: Selecting other products menu
    Given I am on the product selection page
    When I select the "other product" product
    Then I should see all sepulsa's products