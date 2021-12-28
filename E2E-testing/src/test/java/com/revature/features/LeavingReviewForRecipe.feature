Feature: Leaving a review for a recipe

Scenario: Leaving a review while logged in (positive test)
	Given I am at the recipe page while logged in
	When I fill out the review text box
	And I click leave review
	Then I should see my review displayed on the recipe page I am on
	
Scenario: Attempting to leave a review while not logged in (positive test)
	Given I am at the recipe page
	When I click leave review
	Then I should be taken to the login page and prompted to log in
	
Scenario: Attempting to leave a review that is too long (negative test)
	Given I am at the recipe page while logged in
	When I fill out the review test box with too many characters
	Then I should see a message displayed informing me that reviews must be under a character limit
	
	