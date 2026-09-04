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
Feature: Progress Tracking
  As an instructor,
I want to monitor client progress and send motivational reminders,
So that I can help clients achieve their fitness goals.

  

 @tag1
Scenario: Monitor client progress
  Given I am logged in as an instructor
And the client has name "John Doe"  enrolled in the "Advanced Cardio" program,
  Then I should see the details
    


	@tag2
	Scenario: Send a motivational reminder
	Given the client "Jane Smith" is enrolled in the "Advanced Cardio" program,
	When I send a reminder titled "Stay Consistent,"
	Then the client should receive the reminder in their inbox.
	
	
	
	