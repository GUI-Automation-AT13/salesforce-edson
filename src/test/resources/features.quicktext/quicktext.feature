Feature: Create an QuickText

  Scenario: Create an quickText with required fields
    Given Login to salesforce site
    And Navigate to QuickText page
    When Create a new quickText with fields
      | Name    | Quick text from cucumber         |
      | Message | Message quick text from cucumber |
    Then Validate successful message of creating that is display
    And Validate the title matches
    And Validate only the mandatory parameters filled
    And Validate the quickText in the quickText Home

  Scenario: Create an quickText with all fields
    Given Login to salesforce site
    And Navigate to QuickText page
    When Create a new quickText with fields
      | Name       | Quick text from cucumber         |
      | Related To | Account                          |
      | Field      | Account Number                   |
      | Message    | Message quick text from cucumber |
      | Category   | FAQ                              |
      | Channel    | Phone                            |
    Then Validate successful message of creating that is display
    And Validate the title matches
    And Validate all filled fields
    And Validate the quickText in the quickText Home