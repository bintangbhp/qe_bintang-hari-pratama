Feature: Add to cart
    As a user
    I want to add my selected product to card
    So that I can purchase the product

  Scenario: Add Product to Cart
    Given I am on the login page
    When I input valid username
    And I input valid password
    And I click login button
    And I see products image
    And I see products description
    And I click add to cart button
    And I click cart button
    Then I can see my product in cart page