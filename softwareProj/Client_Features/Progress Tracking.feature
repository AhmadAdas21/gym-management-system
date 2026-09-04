# Author: your.email@your.domain.com
# Keywords Summary:
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
# "" (Comments)

@tag
Feature: Progress Tracking
  As a client
  I want to track my fitness progress
  So that I can monitor my achievements and stay motivated

  Scenario: Client views progress for a single enrolled program
    Given the client is logged into the system
    And the client has enrolled in at least one program
    When the client selects "Track Your Progress" from the menu
    Then the system displays the following progress details for each enrolled program:
      | Program Title     | Attended Sessions | Total Sessions | Progress Bar |
      | Weight Loss 101   | 5                 | 10             | 50%          |

  