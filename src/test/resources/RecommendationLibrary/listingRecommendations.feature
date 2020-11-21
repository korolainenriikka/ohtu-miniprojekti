Feature: As a user I want to be able to see my recommendations

    Scenario: List recommendations
        Given command list is selected
        When a command list() is given
        Then app should list all recommendations