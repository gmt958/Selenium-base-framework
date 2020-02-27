

Feature:First feature file to test base class

  Scenario Outline:Launching chrome browser

    Given Launch chrome browser
    And  User navigate to <url>
    And User wait for 1000 milliseconds
    And Choose the close banner
    And Assert the element is displayed "logo" on "loginPage"






    Examples:
      |url                   |
      |"https://www.adobe.com/"|