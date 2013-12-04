import be.kdg.blackjack.model.Card;
import be.kdg.blackjack.model.Deck;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class TestDeck {
    private Deck deck;

    @Before
    public void init() {
        deck = new Deck();
    }

    @Test
    public void test52Cards() {
        assertTrue(deck.getCards().size() == 52);
    }

    // This might fail when the card is back on the same position!
    @Test
    public void testShuffle() {
        Card card = deck.getCards().get(0);
        deck.shuffleCards();
        assertFalse(card.equals(deck.getCards().get(0)));
    }
}
