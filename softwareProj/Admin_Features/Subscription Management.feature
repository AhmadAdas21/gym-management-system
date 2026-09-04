#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
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
@tag
Feature: Subscription Management
The avilable Subscripation Type is : Silver,Gold,Platinum

  @tag1
  Scenario:Manage subscription plans for clients and instructors (e.g., Basic, Premium).
    Given Admin-panel is ready
    And User List is not empty
    When i add a new user , i can detrmine its Subscribation Plan
    And i can update its plan
   
    