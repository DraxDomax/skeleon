Feature: Login
  Check we let the good guys in and keep the bad guys out

  Scenario: Trying to hack the store
    Given The Landing Page
    When User provides "wrong" creds
    Then User should not be logged in
    And User sees login failure

  Scenario: Correctly logging in
    Given The Landing Page
    When User provides "right" creds
    Then User should be logged in

  Scenario: Logging out
    Given The Store Page
    When User clicks LogOut
    Then User should not be logged in