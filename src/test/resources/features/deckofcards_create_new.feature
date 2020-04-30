Feature: Create A new Deck of Cards

  Scenario: Retrieve a new deck of cards
    Given User has access to the API
    And User hits get a new deck of cards
    Then User should get 200 status from api
    And User should get a new deck of cards

  Scenario: Retrieve a new deck of cards with jokers
    Given User has access to the API
    And User asks for a new deck with jokers
    Then User should get 200 status from api
    And User should get a new deck of cards with 2 jokers
