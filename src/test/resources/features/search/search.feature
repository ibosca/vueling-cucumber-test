Feature: Main search

  Narrative:
  In order find available flights
  As a client of https://www.vueling.com/es
  I want to be able to search flights

  Scenario: Initial search
    Given I'm main page
    When I try to find a fly
      | Origin  | Destination | OutboundFly  | ReturnFly            | passengers |
      | Almería | Alicante    | NEXT_WEEK    | THREE_WEEKS_FROM_NOW | 5          |
    Then I get available flight
