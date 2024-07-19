@US01_TC_02

Feature: Sign up should

  Scenario: As a user I should be able to create account
    Given I am on the Telerik website
    When I click on Get A Free Trial button
    And I should see Kendo UI Plan and select UI for React option from Try Now dropdown list
    When I enter valid email and click on Next button
   # Then I enter again when necessary
    And I enter valid password, First Name and Last Name Company, Phone
