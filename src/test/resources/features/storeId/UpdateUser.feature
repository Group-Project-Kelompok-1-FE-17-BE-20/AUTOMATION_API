Feature: UPDATE USER
  @Project
  Scenario Outline: Update user image valid
    Given User updated image "<image>"
    When Send PUT request to update user
    Then Status code should be 200
    And Response body message was "user updated successfully"
    And Validate JSON schema "UserUpdateValidSchema.json"

    Examples:
      | image         |
      | download.jpg  |

