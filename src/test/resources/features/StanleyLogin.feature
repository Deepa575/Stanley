Feature: Validating the Login Functionality

  Scenario Outline: Login Functionality
    Given Open the Stanley IQ TOOLBOX App
    And Accept the Terms and Conditions
    And Enter username and password <username> <password> in Login Screen
    Then Click on Login button

    Examples: 
      | username                        | password      |
      | "vamshi.krishna@vassarlabs.com" | "Vassarlabs1" |
