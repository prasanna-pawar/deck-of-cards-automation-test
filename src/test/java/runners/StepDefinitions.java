package runners;

public class StepDefinitions {
    public static final String API_URL="http://deckofcardsapi.com/api/deck";
    public static final String WITH_JOKERS = "?jokers_enabled=true";
    public static final String NEW_DECK="/new";
    public static final String DRAW_CARDS = "/{deck_id}/draw?count={count}";
}
