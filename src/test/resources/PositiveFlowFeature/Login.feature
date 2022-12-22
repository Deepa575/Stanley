Feature: To Login

  Scenario Outline:Scenario to Login

    Given Enter the username and password <Username> <Password>
    When click on login
    Then verify the home page
    Examples:
      | Username     | Password   |
    |  "superadmin" | "stanley@123"|