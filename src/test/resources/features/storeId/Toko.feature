Feature: Endpoint Toko

  Scenario: Successfully Get Store
    Given Get toko
    When Send request get toko
    Then Status code should be 200


  Scenario Outline: Update nama toko
    Given Update toko with "<toko_id>" and "<json>"
    When Send request update product
    Then Status code should be 200
    Examples:
      | json                | toko_id |
      | UpdateProduct1.json | 19      |

  Scenario Outline: Update alamat toko
    Given Update toko with "<toko_id>" and "<json>"
    When Send request update product
    Then Status code should be 200
    Examples:
      | json                | toko_id |
      | UpdateProduct2.json | 19      |

  Scenario Outline: Delete toko
    Given Delete toko with "<toko_id>"
    When Send request delete toko
    Then Status code should be 200
    Examples:
      | json                | toko_id |
      | UpdateProduct2.json | 21       |

  Scenario Outline: Post toko
    Given Post toko with "<json>"
    When Send request post toko
    Then Status code should be 200
    Examples:
      | json            | toko_id |
      | CreateToko.json | 19       |
