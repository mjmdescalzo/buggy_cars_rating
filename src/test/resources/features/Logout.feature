Feature: User logout


  Scenario: Validate successful user logout
    Given I am at the Home Page
    And I populate the Login Fields
      | field    | value      |
      | Login    | testuser01 |
      | Password | Test12345! |
    And I click the Login button
    When I click the Logout button
    Then the is now logged out
