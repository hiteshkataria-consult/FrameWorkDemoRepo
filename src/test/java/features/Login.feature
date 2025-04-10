Feature: Application Login

  Scenario: Login with valid credentials
    Given Open my broswer
    And Navigate to login page
    And Navigate to login page too
    When User enters username as "testertest@email.com" and password as "test123"
    Then Verify user is able to succesfully login
