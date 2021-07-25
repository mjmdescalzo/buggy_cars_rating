Feature: New user registration

  Scenario: Validate user is redirected to registration page
    Given I am at the Home Page
    When I click Register at the header
    Then I am redirected to the Registration Page


  Scenario: Validate successful user registration
    Given I am the Registration Page
    And I populate the Registration Fields
      | field            | value               |
      | Login            | testuser<timestamp> |
      | First Name       | Albert              |
      | Last Name        | Einstein            |
      | Password         | Testpassword1!      |
      | Confirm Password | Testpassword1!      |
    When I click the Register button
    Then the registration message should be displayed
      """
      Registration is successful
      """

  Scenario Outline: Validate user is not able to register when username and password does not follow the rules
    Given I am the Registration Page
    And I populate the Registration Fields
      | field            | value      |
      | Login            | <Login>    |
      | First Name       | Albert     |
      | Last Name        | Einstein   |
      | Password         | <Password> |
      | Confirm Password | <Password> |
    When I click the Register button
    Then the registration message should be displayed
      """
      <Message>
      """
    Examples:
      | Login               | Password       | Message                                                                                                                                                                                |
      | testuser01          | Testpassword1! | UsernameExistsException: User already exists                                                                                                                                           |
      | testuser 1239719371 | Testpassword1! | InvalidParameterException: 1 validation error detected: Value at 'username' failed to satisfy constraint: Member must satisfy regular expression pattern: [\p{L}\p{M}\p{S}\p{N}\p{P}]+ |
      | testuser1239719371  | testpassword1! | InvalidPasswordException: Password did not conform with policy: Password must have uppercase characters                                                                                |
      | testuser1239719371  | Testpassword1  | InvalidPasswordException: Password did not conform with policy: Password must have symbol characters                                                                                   |
      | testuser1239719371  | Testpassword!  | InvalidPasswordException: Password did not conform with policy: Password must have numeric characters                                                                                  |
      | testuser1239719371  | Test1!         | InvalidPasswordException: Password did not conform with policy: Password not long enough                                                                                               |


  Scenario Outline: Validate user is not able to register when inputs are incomplete
    Given I am the Registration Page
    When I populate the Registration Fields
      | field            | value              |
      | Login            | <Login>            |
      | First Name       | <First Name>       |
      | Last Name        | <Last Name>        |
      | Password         | <Password>         |
      | Confirm Password | <Confirm Password> |
    Then registration should be disabled
    Examples:
      | Login    | First Name | Last Name | Password       | Confirm Password |
      | testuser | Albert     | Einstein  | Testpassword1! |                  |
      | testuser | Albert     | Einstein  |                | Testpassword1!   |
      | testuser | Albert     |           | Testpassword1! | Testpassword1!   |
      | testuser |            | Einstein  | Testpassword1! | Testpassword1!   |
      |          | Albert     | Einstein  | Testpassword1! | Testpassword1!   |


