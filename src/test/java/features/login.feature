Feature: verify Login module is working as expected

  @Regression
  Scenario Outline: Verify Login into application with valid credentials
    Given A user is accessing Fedex portal
    When He attempts to login using valid <username> and <password>
    Then user login is successful
    Examples:
      | username         | password   |
      | mrsrinivas1988   | Test1234   |

  @Regression
  Scenario Outline: Verify Login into application with invalid credentials
    Given A user is accessing Fedex portal
    When He attempts to login using invalid <username> and <password>
    Then user login is not successful
    Examples:
      | username       | password        |
      | mrsrinivas1988 | WrongPassword   |
      | WrongUserId    | WrongPassword   |

