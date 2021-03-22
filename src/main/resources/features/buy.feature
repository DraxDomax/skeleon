Feature: Buy
  Buy stuff in the store

  Scenario: Buy a pencil
    Given The Store Page
    When User clicks on buy pencil
    Then User receives confirmation

  Scenario: Buy a perforator
    Given The Store Page
    When User clicks on buy perforator
    And User "accepts" JS alert
    Then User receives js confirmation