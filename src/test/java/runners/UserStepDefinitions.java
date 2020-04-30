package runners;
import static io.restassured.RestAssured.when;
import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class UserStepDefinitions extends StepDefinitions {
    private Response response;
    private String url;

    @Given("User has access to the API")
    public void user_has_access_to_the_API() {
    }

    @Then("User asks for a new deck with jokers")
    public void user_asks_for_a_deck_with_jokers() {
      url = API_URL + NEW_DECK + WITH_JOKERS;
      response = when().get(url);
    }

    @Then("User hits get a new deck of cards")
    public void user_hits_get_a_new_deck_of_cards() {
        url = API_URL + NEW_DECK;
        response = when().get(url);
    }

    @Then("User should get {int} status from api")
    public void i_should_get_status_from_api(Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        response.then().statusCode(statusCode);
    }

    @Then("User should get a new deck of cards")
    public void i_should_get_a_new_deck_of_cards() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(response.getBody().jsonPath().getBoolean("success"));

    }

    @Then("User tries to draw {int} card from the draw")
    public void user_tries_to_draw_card_from_the_draw(Integer count) {
        String deck_id = response.getBody().jsonPath().getString("deck_id");
        url = API_URL+DRAW_CARDS;
        url = url.replaceAll("\\{count\\}", count.toString());
        url = url.replaceAll("\\{deck_id\\}", deck_id);
        response = when().get(url);
    }

    @Then("User should get {int} cards from the deck")
    public void i_should_get_cards_from_the_deck(int count_of_cards) {
        // Write code here that turns the phrase above into concrete actions
        List<Object> cards = response.getBody().jsonPath().get("cards");
        Assert.assertEquals( count_of_cards ,cards.size());
    }

    @Then("Remaing cards in the deck should be {int}")
    public void remaining_cards_in_the_deck(int remaining_cards) {
        Assert.assertEquals(remaining_cards, response.getBody().jsonPath().getInt("remaining"));
    }
    @Then("User should get a new deck of cards with 2 jokers")
    public void user_should_get_deck_with_Jokers() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals( 54,response.getBody().jsonPath().getInt("remaining"));
    }

    @Then("User has a new deck")
    public void user_has_a_new_deck(){
        user_hits_get_a_new_deck_of_cards();
    }

}
