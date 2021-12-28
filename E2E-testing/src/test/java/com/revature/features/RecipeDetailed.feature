Feature: Random Recipe

Scenario: Ensuring random recipe is random
	Given I am at the welcome page while not logged in
	When I press the random recipe button
	And I press the random recipe button again
	Then I should be taken to a different random recipe