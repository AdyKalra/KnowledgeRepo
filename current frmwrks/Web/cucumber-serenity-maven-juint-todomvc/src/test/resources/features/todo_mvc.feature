@component:ui
@version:Release-1
@issue:ETSY-001
@runThis

Feature: Write some browser tests to validate the correct function of a Javascript Single Page Web Application
  As a user
  1. I want to add a Todo item1.
  2. I want to edit the content of an existing Todo item1.
  3. I can complete a Todo by clicking inside the circle UI to the left of the Todo1.
  4. I can re-activate a completed Todo by clicking inside the circle UI1.
  5. I can add a second Todo1.
  6. I can complete all active Todos by clicking the down arrow at the top-left of the UI1.
  7. I can filter the visible Todos by Completed state1.
  8. I can clear a single Todo item from the list completely by clicking the Close icon.
  9. I can clear all completed Todo items from the list completely

  Scenario Outline: Add items on Todo Page
    Given I am on the todomvc page
    When I enter an '<item>'
    Then I should see the count increased

    Examples:
      | item  |
      | item1 |
      | item2 |

  Scenario Outline: Edit existing item on Todo Page
    Given I am on the todomvc page
    When I edit an '<item>' to '<new item>'
    Then I should see '<item>' edited to <new item>' on the results page

    Examples:
      | item  | new item |
      | 1     | item0    |

  Scenario Outline: Complete an existing item on Todo Page
    Given I am on the todomvc page and '<state>' is selected
    When I change the status
    Then I should see '<item>' changed to completed

    Examples:
      | item  | state |
      | item0 | all   |

  Scenario Outline: re-activate an existing completed item on Todo Page
    Given I am on the todomvc page and '<state>' is selected
    When I change the status
    Then I should see '<item>' reactivated

    Examples:
      | item  | state |
      | item0 | all   |

  Scenario Outline:  Complete all active Todos by clicking the down arrow and filtering the completed state
    Given I am on the todomvc page and '<state>' is selected
    When I activate all active todos
    Then I should see '<item>' changed to completed

    Examples:
      | item  | state     |
      | item0 | completed |
      | item2 | completed |

  Scenario Outline:  Clear a single Todo item from the list completely by clicking the Close icon
    Given I am on the todomvc page and '<state>' is selected
    When I delete the '<item>'
    Then the '<item>' should not be visible

    Examples:
      | item  | state |
      | item0 | all   |


  Scenario Outline:  Clear all completed Todo items from the list completely
    Given I am on the todomvc page and '<state>' is selected
    When I clear all completed
    Then the results page should have no items
    Examples:
      | state |
      | all   |