Feature: Validate the IQ Connect/CIU Configure

  Scenario Outline: CIU Configure
    Given Application Has to open
    And Click on the menu and select IQ Connect
    When Click on CIU Configure button
    And Enter Wifi Configure Screen <customername> <storeid> <doorid> <doortype> <doorlocation> <DCUmodel> <DCUserialno> <CIUserialno> <doorprofile> <WIFISSID>

    Examples: 
      | customername | storeid    | doorid     | doortype     | doorlocation | DCUmodel | DCUserialno  | CIUserialno  | doorprofile    | WIFISSID      |
      | "Walmart"    | "2345-DFG" | "DOOR_123" | "Slide Door" | "Front Door" | "DG3000" | "C22E000008" | "D190000943" | "Sliding Door" | "Cradlepoint" |
