Feature: As a user I want to be able to see my recommendations

	@problem
    Scenario: user can list added recommendations
        Given recommendation with author "AuthorTest", title "TitleTest", and description "DescriptionTest" is added
		When command list is selected
		And command exit is entered
        Then app lists a recommendation with author "AuthorTest", title "TitleTest", and description "DescriptionTest"