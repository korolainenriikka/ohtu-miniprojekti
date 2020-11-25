Feature: As a user I want to be able to see my recommendations

<<<<<<< HEAD
    Scenario: List recommendations
        Given library is given entries
        And command list is selected
        And command exit is entered
        Then app will list all recommendations
=======
	@problem
    Scenario: user can list added recommendations
        Given recommendation with author "AuthorTest", title "TitleTest", and description "DescriptionTest" is added
		When command list is selected
		And command exit is entered
        Then app lists a recommendation with author "AuthorTest", title "TitleTest", and description "DescriptionTest"
>>>>>>> 2a379a9a0b3e31f9a77b241d757ef668054d4612
