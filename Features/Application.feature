#Author: Bharath
#Keywords Summary :
#Feature: OrangeHRM Application
#Scenario: Login, Home Page and Forgot Password Page
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Application Login and Logout Feature
  I want to use this feature file to validate application login and logout functionality

  Background: Enter Url and Launch the Application
    Given Launch The Application
    
  @Sanity
  Scenario: Verify Application Title
    Then Verify The Title

  @Regression
  Scenario Outline: Verify Application Login
    When I Enter <Username> And <Password>
    And Click on Login Button
    Then Application Login Successful

    Examples: 
      | Username | Password |
      | admin    | admin123 |
      | abcde    | admin123 |

  @Regression
  Scenario Outline: Verify Application Logout
    When I Enter <Username> And <Password>
    And Click on Login Button
    Then Application Login Successful
    And Click on Logout Button
    Then Application Logout Successful

    Examples: 
      | Username | Password |
      | admin    | admin123 |
