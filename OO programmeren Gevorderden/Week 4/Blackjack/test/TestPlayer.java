import be.kdg.blackjack.controller.GameController;
import be.kdg.blackjack.model.Card;
import be.kdg.blackjack.model.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class TestPlayer {
    @Test
    public void testAskCard() {
        Player player = new Player("Xavier");

        GameController controller = new GameController();
        controller.addPlayer(player);

        Card card = controller.askCard();
        assertEquals(1, controller.getCurrentPlayer().getCards().size());
        assertEquals("Xavier", player.getName());
    }
}
