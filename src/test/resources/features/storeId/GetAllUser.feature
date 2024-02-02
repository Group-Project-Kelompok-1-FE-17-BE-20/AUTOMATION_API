Feature: GET ALL USERS
  @Project
  Scenario: Get all users with valid path
    Given Get all users with valid path
    When Send request get all users
    Then Status code should be 200
    And Response body code should be 302
    And Validate get all users json schema "GetAllUsersSchema.json"

  @Project
  Scenario: Get all users with invalid path
    When Send request get all users with invalid path
    Then Status code should be 404
    And Validate get all users invalid json schema "GetAllUsersInvalidSchema.json"

    @Project
    Scenario: Get all users with empty path
      Given Get all users with empty path
      Then Status code should be 404

