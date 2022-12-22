Feature: To Add DeviceType

  Scenario Outline:Scenario to Add DeviceType

    Given Go To Add DeviceType Page
    When Enter Details Into Devicetype and Description <deviceType> <description>
    When Click On Submit
    Then Verify Toaster Message <expectedMessage>
    Examples:
      | deviceType   | description   | expectedMessage                     |
      | "Device test 3" | "For Testing 3" | "Device Type Added Successfully" |
