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
Feature: User Mangment Feature
 A fast and secure user management system, enabling administrators to ensure full access and seamless functionality without issues.

 

  @Add,update,and_deactivate_accounts_for_instructors_and_clients.
  
  Scenario: Managing user accounts (add, update, deactivate) for Instructors and Clients
    Given the admin panel (user management system) is ready
    And it contains the following data:
      | Name  | Email             | Password  | Organization | State   | Plan |
      | Ahmad | ahmad@xyz.com     | ahmad123  | Client       | Active  | Gold |
      | Hadi  | hadi@xyz.com      | hadi1231  | Instructor   | Active  | Silver|
    When I add a new user with the following data:
      | Name  | Email             | Password  | Organization | State   | Plan |
      | Eyas  | iyas@xyz.com      | iyas121   | Client       | Active  | Gold |
    Then the new user Eyas should be saved in the system with Active state
When I update the user with email ahmad@xyz.com to have the following data:
  | Name  | Email             | Password  | Organization | State   | Plan  |
  | Ahmad | ahmad@xyz.com     | ahmadadas | Client       | Active  | Gold  |

   
    When I deactivate the user with email hadi@xyz.com  
    Then the state of the user Hadi should be Inactive
    
@Approve_new_Client_registrations
Scenario: New Client Registrations by admin
  Given that the pending account list is not empty and the admin panel is ready
  And the following client registration requests are pending:
    | Name  | Email        | Password  | Organization | State   |
    | Sara  | sara@xyz.com | sara1212  | Client       | Pending |
    | Ali   | ali@xyz.com  | aliali    | Client       | Pending |

  When the admin approves the registration request for Sara
  Then the state of Sara  account should change to "Active
  And the other pending account for Ali should still be Pending so the list will be:
    | Name  | Email        | Password  | Organization | State   |
    | Ali   | ali@xyz.com  | aliali    | Client       | Pending |
    
    
    
 @Monitor_user_activity_and_engagement_statistics.
Scenario: Calculate client statistics and track client activity
  Given the admin-panel is ready
  And the following clients exist in the system:
    | Name    | Role    | Age | Membership | Status   |
    | Karam   | Client  | 28  | Premium    | Active   | 
    | Ali     | Client  | 32  | Gold       | Active   | 
    | Sara    | Client  | 24  | Basic      | Active   | 
    | Lina    | Client  | 29  | Premium    | Active   | 
    | Omar    | Client  | 33  | Gold       | Active   | 
    | Reem    | Client  | 21  | Basic      | Inactive | 
  When the admin requests client statistics
  Then the system should provide the following summary:
    | Metric                             | Value           |
    | Total Number of Logins             | 64              |
    | Most Active Client by Logins       | Ali             |
    | Number of Clients Active Today     | 2               |

    | Average Logins Per Client          | 10.67           |
 
 
   