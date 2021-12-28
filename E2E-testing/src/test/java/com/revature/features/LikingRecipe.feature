Feature: User likes a recipe

Scenario: Attempting to like a recipe while not logged in (negative test)
	Given I am at the recipe page while not logged in
	When I click like recipe
	Then I should be taken to the login page and prompted to log in
	
Scenario: Liking a recipe while logged in (positive test)
	Given I am at the recipe page while logged in
	When I click like recipe
	Then I should see the recipe added to my liked recipes list
	
Scenario: Liking a recipe that a user has already liked while logged in (positive test)
	Given I am at the recipe page while logged in
	When I click like recipe on a recipe ive already liked
	Then I should see the recipe removed from my liked recieps list