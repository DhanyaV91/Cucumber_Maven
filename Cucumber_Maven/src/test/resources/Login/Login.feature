Feature: Login Feature
This feature includes scenario that would validate the following logins
1. Admin Login
2. Negative login

Background:
Given I am able to navigate on to login page

Scenario Outline: Login with different users
When I update the username as "<user>"
And I update the password as "<password>"
And I click on the login button
Then I should see username as "<name>"

Examples:
|user |password|name        |
|Admin|admin123|Welcome Paul|
 

#Scenario: Admin Login
#When I update the username as "Admin"
#And I update the password as "admin123"
#And I click on the login button
#Then I should see username as "Welcome Paul"

Scenario: Negative Login
When I update the username as "linda.anderson"
And I update the password as "linda.anderson"
And I click on the login button
Then I should see error message as "Invalid credentials"