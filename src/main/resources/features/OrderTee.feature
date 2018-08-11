Feature: Order T-Shirt
	As a Customer
	 I want to be able to successfully search and add a tshirt to my cart and place an order
	 In order to buy a tshirt

Background: The customer logs in to the application 
	Given the customer launches the website "http://automationpractice.com" 
	And the customer enters the username "someone@example.com" and password "Password123" 
		
Scenario: The customer places an order successfully
	When The customer navigates to Tee shirt page 
	And the customer adds a tshirt to his cart
	And  The customer places an order
	Then The order should be successfully placed 
	
