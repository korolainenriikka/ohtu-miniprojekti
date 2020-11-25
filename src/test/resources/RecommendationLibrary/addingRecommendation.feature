Feature: As a user I want to be able to add a new recommendation

	@problem
    Scenario: user can add a new recommendation with author, title and description
        Given command add is selected
        When author "AuthorTest" is entered
        And title "TitleTest" is entered
        And description "DescriptionTest" is entered
        And command exit is entered
        Then system will respond with "Recommendation added"
 