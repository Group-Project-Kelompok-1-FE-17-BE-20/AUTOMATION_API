Feature: CREATE USER
  @Project
  Scenario Outline: Post create user with valid json
    Given Post Create user with valid json "<json>"
    When Send request post create user
    Then Status code should be 200
    And Response body code was <code> and message was "<message>"
    And Validate create user json schema "CreateUsersSchema.json"
    Examples:
      | json            | code    | message             |
      | CreateUser.json | 201     | success create user |

  @Project
  Scenario Outline: Post create user with invalid json
    Given Post create user with invalid json "<json>"
    When Send request post create user
    Then Status code should be 400
    Examples:
      | json                    |
      | CreateUserInvalid.json  |
      | CreateUserInvalid2.json |
      #createuserinvalid2.json ini harusnya 404 , masi perbaikan ama team lain

