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
Feature: Client Interaction
 As an instructor,
 I want to interact with enrolled clients,
 So that I can support them and track their progress.

  @tag1
  Scenario: Communicate with clients via messaging
	Given the client  "mahmoud" is enrolled in the "Yoga Essentials" program 
	When I send a message titled "Keep up the good work,"
	Then the client should receive the message in their inbox.
    
  @tag2
  Scenario: Send a progress report to an enrolled client
    Given i generate a progress report with sum details
    When send it 
    Then the client should receive the progress report

	
	
	
	
	
	
	
	
	