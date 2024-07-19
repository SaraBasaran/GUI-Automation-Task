@US01-TC01_SignUpValid

Feature: Sign up should be completed with valid credentials

  Scenario: As a user I should be able to create account
    Given I am on the Telerik website
    When I click on Get A Free Trial button
    And I should see Kendo UI Plan and select UI for React option from Try Now dropdown list
    When I enter valid email and click on Next button
    And I enter valid password, First Name and Last Name Company, Phone
    And I select Egypt from the Country of Residence dropdown list
    And I select Looking for a Testing Tool option from Business Need input
    And I click on Create account button

    ## Feature files are used to draw test steps and once one step is produced if repeated that very same step is applied
    ## to all same step method by this way it helps to keep the code clean and readable.