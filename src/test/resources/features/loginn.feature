Feature: Login functionality test of gillette application

  Scenario: Login successfully using correct credentials
    When User is on login page
    Then User enters correct username and password
    And User click on submit button
    Then User should be on home page
    And Close the browser