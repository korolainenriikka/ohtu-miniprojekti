Feature: As a user I want to be able to add a new recommendation

  Scenario: Add a new recommendation
    Given command add is selected
    When author "AuthorTest", title "TitleTest" and rescription "RescriptionTest" is added
    Then system will respond with ""

  Scenario: Add a new recommendation
    Given command add is selected
    When author "AuthorTest" without title and rescription is added
    Then system will respond with ""
