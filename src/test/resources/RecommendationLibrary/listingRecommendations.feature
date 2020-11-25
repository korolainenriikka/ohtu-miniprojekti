Feature: As a user I want to be able to see my recommendations

    Scenario: List recommendations
        Given library is given entries
        And command list is selected
        And command exit is entered
        Then app will list all recommendations