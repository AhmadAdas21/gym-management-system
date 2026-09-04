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
Feature: Client Account Management
  As a client or admin
  I want to manage client accounts
  So that I can create, log in, approve, deactivate, or reactivate accounts effectively
@tag1
  Scenario: Client creates a new account successfully
    Given the client does not already have an account
    When the client provides the following details:
      | Name      | Email               | Password | Fitness Plan |
      | moh adas  | mohadas@example.com | 123456   | Weight Loss  |
    And the email is not already registered in the system
    Then the system adds the client account with "Pending" status
    And the system informs the client that the account is under review for approval

 


  

  

  

 