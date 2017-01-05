@component:ui
@version:Release-1
@issue:ETSY-001
@runThis

Feature: Write some browser tests to validate the correct function of a Javascript Single Page Web Application
  As a user I want to add a Todo item1.

  Scenario Outline: Add items on Todo Page
    Given I am on the todomvc page
    When I enter an '<item>'
    Then I should see the count increased

    Examples:
      | item  |
      | item1 |
      | item2 |
