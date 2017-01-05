@web
Feature: Google something
  In order to talk better
  As an English student
  I want to look up word definitions

Scenario Outline: GoogleSomething
  Given I am on the Google main page
  When I google '<searchWord>'
  Then the page title is '<pageTitle>'

  Examples:
  | searchWord | pageTitle           |
  | cheese     | Cheese - Wikipedia, the free encyclopedia |
  | yugioh     | www.yugioh-card.com |