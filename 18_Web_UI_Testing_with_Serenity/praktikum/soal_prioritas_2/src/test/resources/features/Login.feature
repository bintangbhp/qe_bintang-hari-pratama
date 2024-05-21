Feature: Login
    As a user
    I want to login
    So that I can using all the feature

    Scenario: Login with Valid Credentials
        Given I am on the landing page
        When I click sign in button on the landing page
        And I am on the login page
        And I input valid email
        And I input valid password
        And I click login button
        And I see loading system to verify
        Then I see a confirmation message for successful login

    Scenario: Login with Invalid Credentials
        Given I am on the landing page
        When I click sign in button on the landing page
        And I am on the login page
        And I input invalid email
        And I input invalid password
        And I click login button
        And I see loading system to verify
        Then I can a error message "Coba ingat-ingat lagi alamat e-mail/ nomor handphone dan password kamu. Masih ada yang salah nih."