Feature: User wants to play the deck and wants to take cards out of it

  Scenario Outline: User needs to draw n number of card(s) from the deck
    Given User has access to the API
    And User has a new deck
    Then User tries to draw <NumberOfCards> card from the draw
    Then User should get 200 status from api
    And User should get <Output> cards from the deck
    And Remaing cards in the deck should be <Remaining>

    Examples:
    | NumberOfCards | Output | Remaining |
    |    2          | 2      |  50       |
    |    10         | 10     |  42       |
    |    20         | 20     |  32       |
    |    52         | 52     |  0        |
