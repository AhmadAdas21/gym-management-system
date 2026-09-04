# Author: your.email@your.domain.com
# Keywords Summary :
# Feature: List of scenarios.
# Scenario: Business rule through list of steps with arguments.
# Given: Some precondition step
# When: Some key actions
# Then: To observe outcomes or validation
# And, But: To enumerate more Given, When, Then steps
# Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
# Examples: Container for a table
# Background: List of steps run before each of the scenarios
# """ (Doc Strings)
# | (Data Tables)
# @ (Tags/Labels): To group Scenarios
# <> (placeholder)
# ""
## (Comments)
# Sample Feature Definition Template

@tag
Feature: Program Monitoring
As an administrator, I want to manage the subscription plans (programs)  
and to see full reports and statistics related to them.

  @tag1
  Scenario: View statistics on the most popular programs by enrollment
    Given the admin panel is ready
    And the user list is not empty
    When I ask for the most popular program
    Then I should see a list of programs sorted by enrollment count
    And the list should include the program name and enrollment numbers

  @tag2
  Scenario: Generate reports on revenue, attendance, and client progress
    Given the statistics list is not empty
    When I ask for a report
    Then the report should include:
      | Report Type      | Included Data                             |
      | Revenue          | Total revenue and revenue by program      |
      | Attendance       | Attendance records for all programs       |
     
    And the report should have a timestamp for when it was generated

 