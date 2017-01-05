@calc
Feature: Calculate something
  In order to test something
  As a tester
  I want to calculate

  Scenario Outline: Add 2 numbers
    Given I started the Calculator
    When I add '<Addend1>' and '<Addend2>'
    Then the result is '<Sum>'

    Examples:
    |Addend1|Addend2|Sum|
    |2      |4      |6  |
    |9      |8      |17 |


  Scenario: Add 3 numbers
    Given I started the Calculator
    When I add the numbers '4', '6' and '8'
    Then the result is '18'

  Scenario: Add a lot of numbers
    Given I started the Calculator
    When I add all these numbers: '1,2,3,4,5,6,7,8,9,8,7,4,0'
    Then the result is '64'