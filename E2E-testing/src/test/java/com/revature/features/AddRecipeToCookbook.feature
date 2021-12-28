Feature: Adding a recipe to a cookbook

Scenario: Adding a recipe to default cookbook while logged in as user (positive test)
	Given I am at the recipe page while logged in 
	When I click add to cookbook
	And I select the default cookbook
	And I navigate to my default cookbook page
	Then I should see the recipe added to my default cookbook
	
Scenario: Attempting to add a recipe to default cookbook while not logged in (positive test)
	Given I am at the recipe page
	When I click add to cookbook
	Then I should be taken to the login page and prompted to login
	
	