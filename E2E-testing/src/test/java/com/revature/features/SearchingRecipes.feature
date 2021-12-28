Feature: Searching recipes #Im just going to set these up to assure we actually get taken to the results page. I think we should
													#leave testing if the results of the query is accurate or not to manual testing

Scenario: Searching by recipe name (positive test)
	Given I am at the welcome page
	When I enter in the name of a meal into the search bar
	And I click the search button
	Then I should be taken to the search results page and see my query displayed

Scenario: Searching by recipe name with category filter (Positive test)
	Given I am at the welcome page
	When I enter in the name of a meal into the search bar
	And I select a category from the filter dropdown 
	And I click the search button
	Then I should be taken to the search results page and see my query and category filter displayed

Scenario: Searching by recipe name with area filter (positive test)
	Given I am at the welcome page
	When I enter in the name of a meal into the search bar
	And I select an area from the filter dropdown
	And I click the search button
	Then I should be taken to the search results page and see my query and area filter displayed

Scenario: Searching by recipe name with tags filter (positive test)
	Given I am at the welcome page
	When I enter in the name of a meal into the search bar
	And I select a tag from the filter dropdown
	And I click the search button
	Then I should be taken to the search results page and see my query and tag filter displayed

Scenario: Searching with empty search query (negative test)
	Given I am at the welcome page
	And I click the search button
	Then I should see a message displayed informing me I cant search for nothing
