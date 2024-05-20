Feature: Get all products
  As a user
  I want to get all data products
  So that I can view full list of the products

  Scenario: Get All Products
    Given I set the API endpoint to retrieve all data products
    When I send a request to retrieve all data products
    And I should receive a status code of 200
    Then I should receive valid data for all products