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
Feature: Content Management
 

  @tag1
  Scenario:Approve Approve or reject wellness articles, tips, or recipes shared by instructors,or user
    Given the admin-panel is ready 
    And the Articls_Tips List is ready
    When the admin aprove the article or tip from instructers,or user
    Then in the user interface it should be shown 
    And thier state is approved
   And if the admin reject the request for tip or article 
   Then the Articls or tips State should be rejected 

  @tag2
  Scenario: Handle user feedback and complaints.
  Given the admin-panel is ready
  And the feedback List is not empty
  Then the admin should see a list of feedbacks, each feedback with user-writter email. 
