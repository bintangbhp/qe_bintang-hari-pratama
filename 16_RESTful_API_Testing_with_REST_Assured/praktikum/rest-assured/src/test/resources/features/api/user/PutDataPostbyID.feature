Feature: Put data post by ID
    As a admin
    I want to update data by ID
    So that I can modify specific details of a post

  Scenario: Update Post with Valid Id
    Given I set API endpoint for post data with ID
    When  I send a PUT request to update the post data with that ID
    Then The post data should be updated successfully
    And I receive status code 200


  Scenario: Update Post with Invalid Id
    Given I set API endpoint for post data with an invalid ID
    When I send a PUT request to update the post data with that invalid ID
    Then I receive status code 404
    And I should receive a message indicating that the post with the given ID does not exist


