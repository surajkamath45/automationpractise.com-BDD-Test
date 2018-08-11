Feature: Update Personal Information 
	As a Customer
	 I want to successfully change my profile information 
	 In order to keep it up-to-date

Background: The Customer logins to the application 
	Given the customer launches the website "http://automationpractice.com" 
	And the customer enters the username "someone@example.com" and password "Password123" 
	
Scenario: The customer sucessfully updates the First Name
	When The customer navigates to the personal information page 
	And the customer updates the first name 
	Then the information should be successfully updated 