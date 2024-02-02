Feature: GET SINGLE USER
  @Project
  Scenario: Get single user with valid id
    Given Get single user with valid
    When Send request get single user
    Then Status code should be 200
    And Validate get single users json schema "GetSingleUserSchema.json"

