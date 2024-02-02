Feature: LOGIN USER
  @Project
  Scenario Outline: Login user with valid json
    Given Login user with valid "<json>"
    When Send request post login user
    Then Status code should be 200
    And Validate login user json schema "LoginAdminSchema.json"
    Examples:
      | json       |
      | LoginUser.json |