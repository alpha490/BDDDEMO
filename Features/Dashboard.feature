Feature: Common statistics verify

  Background: Steps common for all scenrios
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboad

  @regression
  Scenario: Common statistic should be visible
    Given User should be able to see all the common statistics keyword 
    When All the grid should be visible
    Then  close browser

  @regression
  Scenario: Order statistic should be visible
    Given User should be able to see all the Order option
    When User click on the expand button order graph will be display
    Then  close browser

  @regression
  Scenario: Incomplete order value calculate 
    Given User should be able to see all the Incomplete order option
    When User click on the expand button and all total will be added
    Then  close browser