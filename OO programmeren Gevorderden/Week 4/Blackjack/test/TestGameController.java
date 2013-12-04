import be.kdg.blackjack.controller.GameController;
import be.kdg.blackjack.model.Card;
import be.kdg.blackjack.model.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class TestGameController {
    @Test
    public void testStartGame() {
        GameController game = new GameController();
        assertTrue(game.isGameStarted());
    }

    @Test
    public void testDoMove() {
        Player player = new Player("Xavier");
        Player player2 = new Player("Computer");

        GameController controller = new GameController();
        controller.addPlayer(player);
        controller.addPlayer(player2);

        Card card = controller.askCard();
        assertEquals(1, controller.getCurrentPlayer().getCards().size());
        assertEquals("Xavier", player.getName());

        card = controller.askCard();
        assertEquals(2, controller.getCurrentPlayer().getCards().size());
        assertEquals("Xavier", player.getName());

        // We know that after 2 moves we always are below 21, and above 3!
        // Min possible hand = a Ace and a ten
        // Max possible hand = 2 tens, jacks, queens or kings
        int totalValue = controller.getCurrentPlayer().getTotalCardValue();

        assertTrue(22 > totalValue);
        assertTrue(3 < totalValue);

        controller.endPlayerMove();

        assertEquals(player2, controller.getCurrentPlayer());
        assertEquals("Computer", controller.getCurrentPlayer().getName());
        assertEquals(0, controller.getCurrentPlayer().getCards().size());
    }
}
