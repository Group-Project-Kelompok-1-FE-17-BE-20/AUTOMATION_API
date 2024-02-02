Feature: CREATE TOKO
  @Project
  Scenario Outline: Post create toko with valid json
    Given Post Create toko with valid json "<json>"
    When Send request post create toko
    Then Status code should be 200
    And Validate create toko json schema "CreateTokoSchema.json"

    Examples:
      | json            |
      | CreateToko.json |