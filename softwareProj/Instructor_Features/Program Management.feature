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
Feature: Program Management
  I want to manage fitness programs by creating, updating, or deleting them with detailed information

  @tag1
   Scenario: Add details to a fitness program 
    Given i am on program manage page
    And it contains :
      | Title           | Duration  |Difficulty | Goals                   | Attachments           | Price |
      |Advanced Strength|	12 weeks	|Advanced	  |Build muscle and strength|	Video tutorials       |	100   |
      
    When I create a new fitness program with the following details:
      | Title           | Duration  |Difficulty | Goals                | Attachments           | Price |
      | Yoga Essentials | 6 weeks   |Beginner   | Improve flexibility  | Video tutorials       | 50    |
      
    Then the program should be saved successfully
    
    @tag2
  Scenario: update an existing fitness program
	Given a fitness program already exists in the system,
	When i edit the program details such as the title, duration,....,
	Then the system should save the updated information 
	
	@tag3
  Scenario: delete a fitness program
	Given index of program to delete it
	Then the system should remove the program from the catalog 

	@tag4
	Scenario: Set schedules for group sessions
	Given i am on program manage
	When I set schedules for group sessions by selecting the session type (online or in-person), title, date, and time,
	Then the system should record the schedule
    
 @tag5
 Scenario: when lest empty
 Given i add program
 Then should handle it 
	
	
	
	
	
	
	
	