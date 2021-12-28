Feature: User logging in

Scenario: User loggin in successfully (Positive test)
	Given I am at the login page
	When I enter in a valid username
	And I enter in a valid password
	And I click submit
	Then I should be taken to the welcome page and be able to see my name displayed

Scenario: User inputs invalid username (negative test)
	Given I am at the login page
	When I enter an invalid username
	And I enter in a valid password
	And I click submit
	Then I should see a message saying I have an invalid username and password combination
	
Scenario: User inputs invalid password (negative test)
	Given I am at the login page
	When I enter in a valid username
	And I enter in an invalid password
	And I click submit
	Then I should see a message saying I have an invalid username and password combination
	
Scenario: User leaves username blank (negative test)
	Given I am at the login page
	And I enter in a valid password
	And I click submit
	Then I should see a message telling me that username cannot be blank
	
Scenario: User leaves password blank (negative test)
	Given I am at the login page
	When I enter in a valid username
	And I click submit
	Then I should see a message telling me that password cannot be blank
	
	
	

	
	
