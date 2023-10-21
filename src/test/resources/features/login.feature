Feature: Login Functionality

  Scenario Outline: Login to application as valid user
    Given user is on login page
    When user input <username> as username
    And user input <password> as password
    And user click submit
    Then user verify <status> login result

    Examples:
      | username        | password        | status    |
      | standard_user   | secret_sauce    | success   |
      | standard_user2  | secret_sauce2   | error    |