Feature: Login

  Background:
    Given User is on the Login Page

  Scenario Outline: Invalid Login
    When User enters the invalid "<username>" and "<password>"
    Then User will get the error message error message

    Examples:
      | username | password |
      |          | admin123 |
      | admin    |          |
      | user     | user123  |

  Scenario Outline: Valid Login
    When User enters the valid "<username>" and "<password>"
    Then User will be redirected to the Home Page of OrangeHRM

    Examples:
      | username | password |
      | admin    | admin123 |