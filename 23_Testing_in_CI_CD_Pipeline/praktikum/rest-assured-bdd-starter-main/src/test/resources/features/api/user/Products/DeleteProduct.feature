Feature: Delete a product
    As a admin
    I can delete a product
    So that the product is removed from the system  

    # Positive
    Scenario: Delete a valid product
        Given I set API endpoint for delete product
        When I send a request to delete a valid product
        And I get status code 200 after request to delete a valid product
        Then I get a successfull message

    # Negative
    Scenario: Delete an invalid product
        Given I set API endpoint for delete product
        When I send a request to delete an invalid product
        And I get status code 500 after request to delete an invalid product
        Then I receive error after request to delete an invalid product