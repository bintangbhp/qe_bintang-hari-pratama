Feature: Delete post data
    As a admin
    I can delete post data
    So that the post data is removed from the system

    Scenario: Delete with Valid ID
        Given I set API endpoint for delete post data with ID
        When I send a request to delete a post data with ID
        Then I receive status code 200

    Scenario: Delete with Invalid ID
        Given I set API endpoint for delete post data with ID
        When I send a request to delete a post data with ID
        Then I receive status code 400