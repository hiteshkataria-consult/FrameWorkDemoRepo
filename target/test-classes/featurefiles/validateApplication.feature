Feature: Validate Application Decision

  Scenario: Check application decision by ID
    Given the application ID is 10001
    When I query the database for decision
    Then the decision should be "APPROVED"