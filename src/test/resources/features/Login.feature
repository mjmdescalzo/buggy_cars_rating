Feature: New user registration


  Scenario: Validate successful user login
    Given I am at the Home Page
    And I populate the Login Fields
      | field    | value      |
      | Login    | testuser01 |
      | Password | Test12345! |
    When I click the Login button
    Then the welcome message should be displayed
      """
      Hi, test user first name mod
      """


  Scenario Outline: Validate unsuccessful user login
    Given I am at the Home Page
    And I populate the Login Fields
      | field    | value      |
      | Login    | <Login>    |
      | Password | <Password> |
    When I click the Login button
    Then the error message is displayed at the Header
      """
      <Message>
      """
    Examples:
      | Login      | Password    | Message                   | Description        |
      | testuser03 | Test12345!  | Invalid username/password | non existing user  |
      | testuser01 | Test123456! | Invalid username/password | incorrect password |
