import be.kdg.blackjack.controller.GameController;
import be.kdg.blackjack.model.Card;
import be.kdg.blackjack.model.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class TestPlayer {
    @Test
    public void testAskCard() {
        ArrayList<Player> players = new ArrayList<>();
        Player player = new Player("Xavier");
        Player player2 = new Player("Computer");
        players.add(player);
        players.add(player2);

        GameController controller = new GameController(players);

        Card card = controller.getModel().askCard();
        assertEquals(1, controller.getModel().getCurrentPlayer().getCards().size());
        assertEquals("Xavier", player.getName());
    }
}
