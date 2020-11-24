Feature: As a user I want to be able to add a new recommendation

    Scenario: user can add a new recommendation with author, title and description
        Given command add is selected
        When author "AuthorTest" is entered
        And title "TitleTest" is entered
        And description "DescriptionTest" is entered
        Then system will respond with "Recommendation added"

    Scenario: user can add a new recommendation with author, title and description
        Given command add is selected
        When author "AuthorTest" is entered
        And description "DescriptionTest" is entered
        Then system will respond with ""
#	@problem
#	Scenario: user can add a new recommendation with author, title and description
#       Given command add is selected
#       When  author "AuthorTest", title "TitleTest" and description "DescriptionTest" are entered
#       Then  system will respond with "Recommendation added"
#
#	Scenario: user can add a new recommendation with author, title and description
#		Given command add is selected
#		When author "AuthorTest" without title and rescription is added
#		Then system will respond with ""