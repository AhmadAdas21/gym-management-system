Feature: Feedbacks and Suggestions
  As a client
  I want to submit feedback and suggestions
  So that I can share my experience and improve the programs

  @tag1
  Scenario: Submit feedback for a program
    Given I have participated in the program "Weight Loss 101"
    When I enter the feedback "The program was very engaging and informative."
    Then the admin should receive a notification with the feedback

  @tag2
  Scenario: Submit a suggestion to improve the program
    Given I have participated in the program "Weight Loss 101"
    When I enter the suggestion "Please include more flexibility exercises."
    Then the instructor should receive a notification with the suggestion