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
Feature: Program Exploration and Enrollment
  As a client
  I want to explore available programs and enroll in them
  So that I can participate in programs that match my fitness goals
@tag1
  Scenario: Client explores available fitness programs
    Given the client is logged into the system
    When the client selects "Browse Programs" from the menu
    Then the system displays the following details for each program:
      | Title          | Duration | Difficulty | Goals          | Price |
      | Weight Loss 101| 8 weeks  | Beginner   | Weight Loss    | $50   |
      | Muscle Builder | 12 weeks | Intermediate| Muscle Building| $75   |
      | Flexibility Pro| 6 weeks  | Advanced   | Flexibility    | $60   |
@tag2
  Scenario: Client enrolls in an existing program
    Given the client is logged into the system
    And the client has viewed the available programs
    When the client enters the title of the program "Weight Loss 101"
    Then the system checks if the program exists
    And the system enrolls the client in the program
    And the system initializes the client's progress for the program with:
      | Total Sessions | Attended Sessions | Progress Bar |
      | 10             | 0                 | 0%           |
    And the system displays a confirmation message: "You have been successfully enrolled in Weight Loss 101."

