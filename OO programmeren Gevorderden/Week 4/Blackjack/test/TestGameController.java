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
public class TestGameController {
    @Test
    public void testStartGame() {
        ArrayList<Player> players = new ArrayList<>();
        Player player = new Player("Xavier");
        Player player2 = new Player("Computer");
        players.add(player);
        players.add(player2);

        GameController game = new GameController(players);
        assertTrue(game.getModel().isGameStarted());
    }

    @Test
    public void testDoMove() {
        ArrayList<Player> players = new ArrayList<>();
        Player player = new Player("Xavier");
        Player player2 = new Player("Computer");
        players.add(player);
        players.add(player2);

        GameController controller = new GameController(players);

        Card card = controller.getModel().askCard();
        assertEquals(1, controller.getModel().getCurrentPlayer().getCards().size());
        assertEquals("Xavier", player.getName());

        card = controller.getModel().askCard();
        assertEquals(2, controller.getModel().getCurrentPlayer().getCards().size());
        assertEquals("Xavier", player.getName());

        // We know that after 2 moves we always are below 21, and above 3!
        // Min possible hand = a Ace and a ten
        // Max possible hand = 2 tens, jacks, queens or kings
        int totalValue = controller.getModel().getCurrentPlayer().getTotalCardValue();

        assertTrue(22 > totalValue);
        assertTrue(3 < totalValue);

        controller.endPlayerMove();

        assertEquals(player2, controller.getModel().getCurrentPlayer());
        assertEquals("Computer", controller.getModel().getCurrentPlayer().getName());
        assertEquals(0, controller.getModel().getCurrentPlayer().getCards().size());
    }
}
