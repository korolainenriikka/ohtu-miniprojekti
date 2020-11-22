Feature: As a user I want to be able to add a new recommendation

	@problem
	Scenario: user can add a new recommendation
       Given command add is selected
       When  author "AuthorTest", title "TitleTest" and description "DescriptionTest" are entered
       Then  system will respond with "Recommendation added"

	Scenario: Add a new recommendation
		Given command add is selected
		When author "AuthorTest" without title and rescription is added
		Then system will respond with ""