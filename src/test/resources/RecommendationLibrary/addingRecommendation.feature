Feature: As a user I want to be able to add a new book recommendation

	@problem
    Scenario: user can add a new book recommendation
        Given command add is selected
        When book recommendation with author "AuthorTest", title "TitleTest", description "DescriptionTest", and isbn "isbnTest" is added
        Then system will respond with "Recommendation added"