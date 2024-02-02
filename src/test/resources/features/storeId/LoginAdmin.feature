Feature: LOGIN ADMIN
  @Project
  Scenario Outline: Login admin with valid json
    Given Login admin with valid "<json>"
    When Send request post login admin
    Then Status code should be 200
    And Validate login admin json schema "LoginAdminSchema.json"
    Examples:
      | json            |
      | LoginAdmin.json |