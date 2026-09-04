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
Feature: schedule

  @tag1
  Scenario: Notify clients about schedule changes
	Given a group session for "Yoga Essentials" is scheduled on "2024-11-30" at "10:00 AM "
	When I reschedule it at "2024-12-1" 
	And I reschedule it at "10:00 AM" 
	Then all enrolled clients should receive a notification about the schedule change for date.
	And all enrolled clients should receive a notification about the schedule change for time

  @tag2
  Scenario: Announce a new program
	Given I have created a new program titled "Strength Mastery "	
	And I have created a new Chedule titled "Strength Mastery "
	Then all clients should receive a notification with the program details.
	
	@tag3
	Scenario: special offers
	Given I make offer to  program titled "Strength Mastery "
	Then all clients should receive a notification for this offer.