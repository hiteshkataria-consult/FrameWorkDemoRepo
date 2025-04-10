Feature: Simple API Test

  Scenario: Verify GET status
    When I hit the GET endpoint "https://reqres.in/api/users/2"
    Then the response code should be 200